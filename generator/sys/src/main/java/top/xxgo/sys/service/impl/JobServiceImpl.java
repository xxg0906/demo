package top.xxgo.sys.service.impl;

import top.xxgo.sys.model.entity.Job;
import top.xxgo.sys.mapper.JobMapper;
import top.xxgo.sys.service.IJobService;
import top.xxgo.common.base.PagedBaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 定时任务调度表 服务实现类
 * </p>
 *
 * @author xxg
 * @since 2022-04-01
 */
@Service
public class JobServiceImpl extends PagedBaseServiceImpl<JobMapper, Job> implements IJobService {

}
