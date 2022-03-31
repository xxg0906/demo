package top.xxgo.generator.pojo;

import lombok.Builder;
import lombok.Data;

/**
 * @author xxg
 * @date 2022/3/31 11:43
 */
@Data
@Builder
public class DbInfo {

    private String url;
    private String userName;
    private String password;

    /**
     * 数据库  库名
     */
    private String dbName;


}
