package top.xxgo.sys.service.impl;

import top.xxgo.sys.model.entity.RoleMenu;
import top.xxgo.sys.mapper.RoleMenuMapper;
import top.xxgo.sys.service.IRoleMenuService;
import top.xxgo.common.base.PagedBaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色和菜单关联表 服务实现类
 * </p>
 *
 * @author xxg
 * @since 2022-04-01
 */
@Service
public class RoleMenuServiceImpl extends PagedBaseServiceImpl<RoleMenuMapper, RoleMenu> implements IRoleMenuService {

}
