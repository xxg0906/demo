package top.xxgo.sys.service.impl;

import top.xxgo.sys.model.entity.Config;
import top.xxgo.sys.mapper.ConfigMapper;
import top.xxgo.sys.service.IConfigService;
import top.xxgo.common.base.PagedBaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 参数配置表 服务实现类
 * </p>
 *
 * @author xxg
 * @since 2022-04-01
 */
@Service
public class ConfigServiceImpl extends PagedBaseServiceImpl<ConfigMapper, Config> implements IConfigService {

}
