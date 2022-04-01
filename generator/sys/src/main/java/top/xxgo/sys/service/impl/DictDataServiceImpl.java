package top.xxgo.sys.service.impl;

import top.xxgo.sys.model.entity.DictData;
import top.xxgo.sys.mapper.DictDataMapper;
import top.xxgo.sys.service.IDictDataService;
import top.xxgo.common.base.PagedBaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 字典数据表 服务实现类
 * </p>
 *
 * @author xxg
 * @since 2022-04-01
 */
@Service
public class DictDataServiceImpl extends PagedBaseServiceImpl<DictDataMapper, DictData> implements IDictDataService {

}
