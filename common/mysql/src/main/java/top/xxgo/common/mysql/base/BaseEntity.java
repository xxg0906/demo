package top.xxgo.common.mysql.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author xxg
 * @date 2022/3/10 10:30
 */
@Data
public class BaseEntity {


    @TableField(value = "create_by",fill = FieldFill.INSERT)
    public String createBy;
    @TableField(value = "update_by",fill = FieldFill.UPDATE)
    public String updateBy;
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    public LocalDateTime createTime;
    @TableField(value = "update_time",update = "now()")
    public LocalDateTime updateTime;



}
