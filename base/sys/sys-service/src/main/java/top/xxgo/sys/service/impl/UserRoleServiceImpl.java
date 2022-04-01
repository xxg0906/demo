package top.xxgo.sys.service.impl;

import top.xxgo.sys.model.entity.UserRole;
import top.xxgo.sys.mapper.UserRoleMapper;
import top.xxgo.sys.service.IUserRoleService;
import top.xxgo.common.base.PagedBaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户和角色关联表 服务实现类
 * </p>
 *
 * @author xxg
 * @since 2022-04-01
 */
@Service
public class UserRoleServiceImpl extends PagedBaseServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
