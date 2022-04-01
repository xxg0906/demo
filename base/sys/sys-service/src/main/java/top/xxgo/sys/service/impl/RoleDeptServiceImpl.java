package top.xxgo.sys.service.impl;

import top.xxgo.sys.model.entity.RoleDept;
import top.xxgo.sys.mapper.RoleDeptMapper;
import top.xxgo.sys.service.IRoleDeptService;
import top.xxgo.common.base.PagedBaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色和部门关联表 服务实现类
 * </p>
 *
 * @author xxg
 * @since 2022-04-01
 */
@Service
public class RoleDeptServiceImpl extends PagedBaseServiceImpl<RoleDeptMapper, RoleDept> implements IRoleDeptService {

}
