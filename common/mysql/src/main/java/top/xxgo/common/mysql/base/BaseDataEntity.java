package top.xxgo.common.mysql.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author xxg
 * @date 2022/3/10 10:30
 */
@Data
public class BaseDataEntity {


    @TableField(value = "create_by",fill = FieldFill.INSERT)
    public String createBy;
    @TableField(value = "create_by",fill = FieldFill.UPDATE)
    public String updateBy;
    @TableField(value = "create_by",fill = FieldFill.INSERT)
    public LocalDateTime createTime;
    @TableField(value = "create_by",update = "now()")
    public LocalDateTime updateTime;

    @Version
    public Integer version;
    @TableField(value = "remarks")
    public String remarks;
    @TableLogic
    public Boolean deleted;



}
