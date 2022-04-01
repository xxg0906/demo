package top.xxgo.sys.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import top.xxgo.common.base.BaseDataEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 系统访问记录
 * </p>
 *
 * @author xxg
 * @since 2022-04-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_logininfor")
@ApiModel(value="Logininfor对象", description="系统访问记录")
public class Logininfor extends BaseDataEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "访问ID")
    @TableId(value = "info_id", type = IdType.AUTO)
    private Long infoId;

    @ApiModelProperty(value = "用户账号")
    @TableField("user_name")
    private String userName;

    @ApiModelProperty(value = "登录IP地址")
    @TableField("ipaddr")
    private String ipaddr;

    @ApiModelProperty(value = "登录状态（0成功 1失败）")
    @TableField("status")
    private String status;

    @ApiModelProperty(value = "提示信息")
    @TableField("msg")
    private String msg;

    @ApiModelProperty(value = "访问时间")
    @TableField("access_time")
    private Date accessTime;


}
