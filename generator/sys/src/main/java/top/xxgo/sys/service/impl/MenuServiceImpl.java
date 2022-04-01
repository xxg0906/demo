package top.xxgo.sys.service.impl;

import top.xxgo.sys.model.entity.Menu;
import top.xxgo.sys.mapper.MenuMapper;
import top.xxgo.sys.service.IMenuService;
import top.xxgo.common.base.PagedBaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author xxg
 * @since 2022-04-01
 */
@Service
public class MenuServiceImpl extends PagedBaseServiceImpl<MenuMapper, Menu> implements IMenuService {

}