package top.xxgo.sys.service.impl;

import top.xxgo.sys.model.entity.Dept;
import top.xxgo.sys.mapper.DeptMapper;
import top.xxgo.sys.service.IDeptService;
import top.xxgo.common.base.PagedBaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author xxg
 * @since 2022-04-01
 */
@Service
public class DeptServiceImpl extends PagedBaseServiceImpl<DeptMapper, Dept> implements IDeptService {

}
