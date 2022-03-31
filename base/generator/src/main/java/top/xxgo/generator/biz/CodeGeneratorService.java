package top.xxgo.generator.biz;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.springframework.stereotype.Service;
import top.xxgo.generator.pojo.DbInfo;
import top.xxgo.generator.pojo.GeneratorDto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xxg
 * @date 2022/3/14 16:23
 */
@Service
public class CodeGeneratorService {


    private static final String BASE_PATH = "top.xxgo";

    public boolean generate(GeneratorDto generatorDto) {
        AutoGenerator autoGenerator = new AutoGenerator(getDataSourceConfig(generatorDto));
        autoGenerator.global(getGlobalConfig(generatorDto))
                .packageInfo(getPackageConfig(generatorDto))
                .strategy(getStrategyConfig(generatorDto))
                .injection(getInjectionConfig(generatorDto))
                .template(getTemplateConfig(generatorDto))
                .execute();
        return true;
    }

    private static String getDateTime() {
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDate.format(formatter);
    }

    private static InjectionConfig getInjectionConfig(GeneratorDto generatorDto) {
        InjectionConfig injectionConfig = new InjectionConfig();
        Map<String, Object> map = new HashMap<>(4);
        map.put("dateTime", getDateTime());
        final String projectPath = System.getProperty("user.dir");
//        List<FileOutConfig> fileOutConfigList = new ArrayList<FileOutConfig>();
//        // 自定义配置会被优先输出
//        fileOutConfigList.add(new FileOutConfig("/templates/mapper.xml.vm") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输出文件名，如果entity设置了前后缀，此次注意xml的名称也会跟着发生变化
//                return projectPath + "/src/main/resources/mapper/" +
//                        moduleName + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
//            }
//        });
//        injectionConfig.
//        setFileOutConfigList(fileOutConfigList);
        return  injectionConfig;



    }


    private static StrategyConfig getStrategyConfig(GeneratorDto generatorDto) {
        StrategyConfig.Builder builder = new StrategyConfig.Builder()
                .addInclude(generatorDto.getTableName())
                .addTablePrefix(generatorDto.getTablePrefix() + "_");
        builder.entityBuilder()
                .naming(NamingStrategy.underline_to_camel)
                .columnNaming(NamingStrategy.underline_to_camel)
                .enableTableFieldAnnotation()
                .enableLombok()
                .enableRemoveIsPrefix();
        builder.controllerBuilder().enableHyphenStyle().enableRestStyle();
        return builder.build();
    }

    private static PackageConfig getPackageConfig(GeneratorDto generatorDto) {
        return new PackageConfig.Builder().moduleName(generatorDto.getModuleName())
                .parent(BASE_PATH).build();

    }

    private DataSourceConfig getDataSourceConfig(GeneratorDto generatorDto) {
        DbInfo dbInfo = generatorDto.getDbInfo();
        return new DataSourceConfig
                .Builder(dbInfo.getUrl(), dbInfo.getUserName(), dbInfo.getPassword())
                .build();
    }

    private static GlobalConfig getGlobalConfig(GeneratorDto generatorDto) {
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + "/" + generatorDto.getModuleName() + "src/main/java";
        if (isWindows()) {
            filePath = filePath.replaceAll("/+|\\\\+", "\\\\");
        } else {
            filePath = filePath.replaceAll("/+|\\\\+", "/");
        }
        return new GlobalConfig.Builder()
                .outputDir(filePath)
                .dateType(DateType.ONLY_DATE)
                .author(generatorDto.getAuthor())
                .enableSwagger()
                .openDir(false)
                .fileOverride()
                .build();
    }

    private static TemplateConfig getTemplateConfig(GeneratorDto generatorDto) {
        return new TemplateConfig.Builder()
                .controller("templates/controller.java.vm")
                .service("templates/service.java.vm",
                        "templates/serviceImpl.java.vm")
                .entity("templates/entity.java.vm")
                .mapper("templates/mapper.java.vm")
                .mapperXml("/templates/mapper.xml.vm")
                .build();
    }



    public static boolean isWindows() {
        return System.getProperties().getProperty("os.name").toUpperCase().contains("WINDOWS");
    }

}