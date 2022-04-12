package top.xxgo.gateway.security;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.ReactiveAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import reactor.core.publisher.Mono;
import top.xxgo.core.config.GlobalConstants;
import top.xxgo.core.config.SecurityConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 自定义授权管理
 * @author xxg
 * @date 2022/4/6 10:05
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class CusAuthorizationManager  implements ReactiveAuthorizationManager<AuthorizationContext> {

    private final RedisTemplate<String, Object> redisTemplate;

    /**
     * 检查当前角色是否可以访问当前url
     * @param mono 登录用户信息
     * @param authorizationContext 请求信息
     * @return 检查结果
     */
    @Override
    public Mono<AuthorizationDecision> check(Mono<Authentication> mono, AuthorizationContext authorizationContext) {
        ServerHttpRequest request = authorizationContext.getExchange().getRequest();
        if (request.getMethod() == HttpMethod.OPTIONS) { // 预检请求放行
            return Mono.just(new AuthorizationDecision(true));
        }
        PathMatcher pathMatcher = new AntPathMatcher();
        String method = request.getMethodValue();
        String path = request.getURI().getPath();
        String restfulPath = method + ":" + path;
        String token = request.getHeaders().getFirst(SecurityConstants.AUTHORIZATION_KEY);

        if (StrUtil.isBlank(token) || !StrUtil.startWithIgnoreCase(token, SecurityConstants.JWT_PREFIX)) {
            return Mono.just(new AuthorizationDecision(false));
        }
        Map<Object, Object> urlPermRolesRules = redisTemplate.opsForHash().entries(GlobalConstants.URL_PERM_ROLES_KEY);
        // 拥有访问权限的角色
        List<String> authorizedRoles = new ArrayList<>(8);
        for (Map.Entry<Object, Object> permRoles : urlPermRolesRules.entrySet()) {
            String perm = permRoles.getKey().toString();
            if (pathMatcher.match(perm, restfulPath)) {
                List<String> roles = Convert.toList(String.class, permRoles.getValue());
                authorizedRoles.addAll(roles);
            }
        }
        if (authorizedRoles.isEmpty()) {
            return Mono.just(new AuthorizationDecision(true));
        }
        return mono.filter(Authentication::isAuthenticated)
                .flatMapIterable(Authentication::getAuthorities)
                .map(GrantedAuthority::getAuthority)
                .any(authority -> {
                    String roleCode = authority.substring(SecurityConstants.AUTHORITY_PREFIX.length()); // 用户的角色
                    if (GlobalConstants.ROOT_ROLE_CODE.equals(roleCode)) {
                        return true;
                    }
                    return authorizedRoles.contains(roleCode);
                })
                .map(AuthorizationDecision::new)
                .defaultIfEmpty(new AuthorizationDecision(false));
    }

    @Override
    public Mono<Void> verify(Mono<Authentication> authentication, AuthorizationContext object) {
        return ReactiveAuthorizationManager.super.verify(authentication, object);
    }
}
