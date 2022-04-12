package top.xxgo.sys.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import top.xxgo.common.base.BaseDataEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 定时任务调度日志表
 * </p>
 *
 * @author xxg
 * @since 2022-04-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_job_log")
@ApiModel(value="JobLog对象", description="定时任务调度日志表")
public class JobLog extends BaseDataEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "任务日志ID")
    @TableId(value = "job_log_id", type = IdType.AUTO)
    private Long jobLogId;

    @ApiModelProperty(value = "任务名称")
    @TableField("job_name")
    private String jobName;

    @ApiModelProperty(value = "任务组名")
    @TableField("job_group")
    private String jobGroup;

    @ApiModelProperty(value = "调用目标字符串")
    @TableField("invoke_target")
    private String invokeTarget;

    @ApiModelProperty(value = "日志信息")
    @TableField("job_message")
    private String jobMessage;

    @ApiModelProperty(value = "执行状态（0正常 1失败）")
    @TableField("status")
    private String status;

    @ApiModelProperty(value = "异常信息")
    @TableField("exception_info")
    private String exceptionInfo;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;


}
