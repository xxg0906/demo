package top.xxgo.sys.service.impl;

import top.xxgo.sys.model.entity.JobLog;
import top.xxgo.sys.mapper.JobLogMapper;
import top.xxgo.sys.service.IJobLogService;
import top.xxgo.common.base.PagedBaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 定时任务调度日志表 服务实现类
 * </p>
 *
 * @author xxg
 * @since 2022-04-01
 */
@Service
public class JobLogServiceImpl extends PagedBaseServiceImpl<JobLogMapper, JobLog> implements IJobLogService {

}
