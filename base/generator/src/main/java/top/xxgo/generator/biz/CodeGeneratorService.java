package top.xxgo.generator.biz;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.springframework.stereotype.Service;
import top.xxgo.generator.pojo.DbInfo;
import top.xxgo.generator.pojo.GeneratorDto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xxg
 * @date 2022/3/14 16:23
 */
@Service
public class CodeGeneratorService {


    private static final String BASE_PATH = "top.xxgo";

    public boolean generate(GeneratorDto generatorDto) {
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setDataSource(getDataSourceConfig(generatorDto));
        autoGenerator.setGlobalConfig(getGlobalConfig(generatorDto));
        autoGenerator.setPackageInfo(getPackageConfig(generatorDto));
        autoGenerator.setStrategy(getStrategyConfig(generatorDto));
        autoGenerator.setCfg(getInjectionConfig(generatorDto));
        autoGenerator.setTemplate(getTemplateConfig(generatorDto));
        autoGenerator.execute();
        return true;
    }

    private static String getDateTime() {
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDate.format(formatter);
    }

    private static InjectionConfig getInjectionConfig(GeneratorDto generatorDto) {
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {

            }
        };
        Map<String, Object> map = new HashMap<>(4);
        map.put("dateTime", getDateTime());
        final String projectPath = System.getProperty("user.dir");
        List<FileOutConfig> fileOutConfigList = new ArrayList<>();
        // 自定义配置会被优先输出
        fileOutConfigList.add(new FileOutConfig("templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名，如果entity设置了前后缀，此次注意xml的名称也会跟着发生变化
                return projectPath + "/gen/"+generatorDto.getModuleName()+"/src/main/resources/mapper/" +tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        injectionConfig.setFileOutConfigList(fileOutConfigList);
//        injectionConfig.
//        setFileOutConfigList(fileOutConfigList);
        return  injectionConfig;



    }


    private static StrategyConfig getStrategyConfig(GeneratorDto generatorDto) {
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
//                .setInclude(generatorDto.getTableName())
                .setTablePrefix(generatorDto.getTablePrefix() + "_")
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setEntityLombokModel(true)
                .setEntityBooleanColumnRemoveIsPrefix(true)
                .setEntityTableFieldAnnotationEnable(true)
                .setRestControllerStyle(true)
                .setSuperEntityClass("top.xxgo.common.base.BaseDataEntity")
                .setSuperControllerClass("top.xxgo.project.version.BaseController")
                .setSuperServiceClass(  "top.xxgo.common.base.PagedBaseService ")
                .setSuperServiceImplClass("top.xxgo.common.base.PagedBaseServiceImpl")
                .setSuperMapperClass("top.xxgo.common.base.PageMapper")
        ;
         return strategyConfig;
    }

    private static PackageConfig getPackageConfig(GeneratorDto generatorDto) {
        return new PackageConfig()
                .setModuleName(generatorDto.getModuleName())
                .setController("controller.rest")
                .setEntity("model.entity")
                .setParent(BASE_PATH);
    }

    private DataSourceConfig getDataSourceConfig(GeneratorDto generatorDto) {
        DbInfo dbInfo = generatorDto.getDbInfo();
        DataSourceConfig dataSourceConfig = new DataSourceConfig().setUrl(dbInfo.getUrl())
                .setUsername(dbInfo.getUserName())
                .setPassword(dbInfo.getPassword())
                .setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setSchemaName("");
        return dataSourceConfig;
    }

    private static GlobalConfig getGlobalConfig(GeneratorDto generatorDto) {
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + "/gen/" + generatorDto.getModuleName() + "/src/main/java";
        if (isWindows()) {
            filePath = filePath.replaceAll("/+|\\\\+", "\\\\");
        } else {
            filePath = filePath.replaceAll("/+|\\\\+", "/");
        }
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(filePath);
        globalConfig.setDateType((DateType.ONLY_DATE));
        globalConfig.setAuthor(generatorDto.getAuthor());
        globalConfig.setSwagger2(true);
        globalConfig.setOpen(false);
        globalConfig.setFileOverride(true);
        globalConfig.setBaseResultMap(true);

        return globalConfig;
    }

    private static TemplateConfig getTemplateConfig(GeneratorDto generatorDto) {
        return new TemplateConfig()
                .setController("templates/controller.java.vm")
                .setService("templates/service.java.vm")
                 .setServiceImpl("templates/serviceImpl.java.vm")
                .setEntity("templates/entity.java.vm")
                .setXml(null)
                .setMapper("templates/mapper.java.vm");
    }



    public static boolean isWindows() {
        return System.getProperties().getProperty("os.name").toUpperCase().contains("WINDOWS");
    }

}