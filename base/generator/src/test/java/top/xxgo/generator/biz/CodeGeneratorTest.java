package top.xxgo.generator.biz;

import org.junit.jupiter.api.Test;
import top.xxgo.generator.pojo.DbInfo;
import top.xxgo.generator.pojo.GeneratorDto;


/**
 * @author xxg
 * @date 2022/3/31 11:41
 */
class CodeGeneratorTest {


    public static void main(String[] args) {
        CodeGeneratorService codeGeneratorService = new CodeGeneratorService();
        DbInfo dbInfo = DbInfo.builder()
                .url("jdbc:mysql://localhost:3306/xxgo-sys?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8&autoReconnect=true&rewriteBatchedStatements=true")
                .userName("root")
                .password("123456")
                .build();
        GeneratorDto generatorDto = GeneratorDto.builder()
                .author("xxg")
                .basePacage("com.xxgo")
                .filePath("")
                .moduleName("sys")
                .tablePrefix("sys")
                .tableName(new String[]{"sys_role"})
                .dbInfo(dbInfo)
                .build();
        codeGeneratorService.generate(generatorDto);
    }

    @Test
    public  void gen(){

    }


}