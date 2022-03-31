package top.xxgo.generator.pojo;

import lombok.Builder;
import lombok.Data;

/**
 * @author xxg
 * @date 2022/3/14 16:38
 */
@Data
@Builder
public class GeneratorDto {

    /**
     * 数据库表名
     */
    private String[] tableName;

    private String   tablePrefix;

    /**
     * 作者
     */
    private String author;
    /**
     * 代码基础路径
     */
    private String basePacage;

    /**
     * 生成代码保存路径
     */
    private  String filePath;


    /**
     * 模块名称
     */
    private String moduleName;



    private  DbInfo dbInfo;


}
