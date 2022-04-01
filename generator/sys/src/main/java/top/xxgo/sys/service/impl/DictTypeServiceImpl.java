package top.xxgo.sys.service.impl;

import top.xxgo.sys.model.entity.DictType;
import top.xxgo.sys.mapper.DictTypeMapper;
import top.xxgo.sys.service.IDictTypeService;
import top.xxgo.common.base.PagedBaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 字典类型表 服务实现类
 * </p>
 *
 * @author xxg
 * @since 2022-04-01
 */
@Service
public class DictTypeServiceImpl extends PagedBaseServiceImpl<DictTypeMapper, DictType> implements IDictTypeService {

}
