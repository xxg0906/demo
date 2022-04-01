package top.xxgo.sys.service.impl;

import top.xxgo.sys.model.entity.Role;
import top.xxgo.sys.mapper.RoleMapper;
import top.xxgo.sys.service.IRoleService;
import top.xxgo.common.base.PagedBaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author xxg
 * @since 2022-04-01
 */
@Service
public class RoleServiceImpl extends PagedBaseServiceImpl<RoleMapper, Role> implements IRoleService {

}
