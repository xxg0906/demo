package top.xxgo.sys.service.impl;

import top.xxgo.sys.model.entity.UserPost;
import top.xxgo.sys.mapper.UserPostMapper;
import top.xxgo.sys.service.IUserPostService;
import top.xxgo.common.base.PagedBaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户与岗位关联表 服务实现类
 * </p>
 *
 * @author xxg
 * @since 2022-04-01
 */
@Service
public class UserPostServiceImpl extends PagedBaseServiceImpl<UserPostMapper, UserPost> implements IUserPostService {

}
