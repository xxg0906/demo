package top.xxgo.sys.service.impl;

import top.xxgo.sys.model.entity.Logininfor;
import top.xxgo.sys.mapper.LogininforMapper;
import top.xxgo.sys.service.ILogininforService;
import top.xxgo.common.base.PagedBaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统访问记录 服务实现类
 * </p>
 *
 * @author xxg
 * @since 2022-04-01
 */
@Service
public class LogininforServiceImpl extends PagedBaseServiceImpl<LogininforMapper, Logininfor> implements ILogininforService {

}
