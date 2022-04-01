package top.xxgo.sys.service.impl;

import top.xxgo.sys.model.entity.Post;
import top.xxgo.sys.mapper.PostMapper;
import top.xxgo.sys.service.IPostService;
import top.xxgo.common.base.PagedBaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 岗位信息表 服务实现类
 * </p>
 *
 * @author xxg
 * @since 2022-04-01
 */
@Service
public class PostServiceImpl extends PagedBaseServiceImpl<PostMapper, Post> implements IPostService {

}
