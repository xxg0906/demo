package top.xxgo.sys.service.impl;

import top.xxgo.sys.model.entity.User;
import top.xxgo.sys.mapper.UserMapper;
import top.xxgo.sys.service.IUserService;
import top.xxgo.common.base.PagedBaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author xxg
 * @since 2022-04-01
 */
@Service
public class UserServiceImpl extends PagedBaseServiceImpl<UserMapper, User> implements IUserService {

}
