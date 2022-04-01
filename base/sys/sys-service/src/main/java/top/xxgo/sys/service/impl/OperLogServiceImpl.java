package top.xxgo.sys.service.impl;

import top.xxgo.sys.model.entity.OperLog;
import top.xxgo.sys.mapper.OperLogMapper;
import top.xxgo.sys.service.IOperLogService;
import top.xxgo.common.base.PagedBaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作日志记录 服务实现类
 * </p>
 *
 * @author xxg
 * @since 2022-04-01
 */
@Service
public class OperLogServiceImpl extends PagedBaseServiceImpl<OperLogMapper, OperLog> implements IOperLogService {

}
