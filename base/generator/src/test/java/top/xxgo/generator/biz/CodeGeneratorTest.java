package top.xxgo.generator.biz;

import org.junit.jupiter.api.Test;
import top.xxgo.generator.pojo.DbInfo;
import top.xxgo.generator.pojo.GeneratorDto;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author xxg
 * @date 2022/3/31 11:41
 */
class CodeGeneratorTest {


    @Test
    public  void gen(){
        CodeGeneratorService codeGeneratorService = new CodeGeneratorService();
        DbInfo dbInfo = DbInfo.builder()
                .url("jdbc:mysql://localhost:3306/xxgo-sys??useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&serverTimezone=Asia/Shanghai")
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


}