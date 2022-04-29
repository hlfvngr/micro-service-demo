package com.hlfv.demoauth.codegen;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class CodeGenerator {
    public static void main(String[] args) {

        String moduleName = "demo-auth"; //模块名称
        String url = "jdbc:mysql://localhost:3306/demo?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&serverTimezone=GMT%2B8";
        String Driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "wdkynbd";
        String include = "sys_account,sys_account_role,sys_role,sys_role_menu,sys_menu";    //数据库表名
        String parentPackage = "com.hflv.demoauth.account";  //父包包名
        boolean onlyEntity = false; //是否只生成实体类
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir"); //获得项目名
        gc.setOutputDir(projectPath + "/" + moduleName + "/src/main/java"); //如果需要区分模块，在此添加模块名
        gc.setAuthor("hflv");
        gc.setOpen(false);//生成后是否打开资源管理器
        gc.setFileOverride(false); //重新生成时文件是否覆盖
        gc.setServiceName("%sService"); //去掉Service接口的首字母I
        gc.setDateType(DateType.TIME_PACK);//定义生成的实体类中日期类型
        gc.setSwagger2(true); //实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(url);
        // dsc.setSchemaName("public");
        dsc.setDriverName(Driver);
        dsc.setUsername(userName);
        dsc.setPassword(password);
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        /**
         * 输出模板，如果按照官方原生的可以不配置，也可以配置自定义的模板
         */
        TemplateConfig templateConfig = new TemplateConfig();
        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别，默认vm，xml不输出
        templateConfig.setEntity("templates/entity.java");
        if (onlyEntity) {
            templateConfig.setService(null);
            templateConfig.setServiceImpl(null);
            templateConfig.setController(null);
            templateConfig.setMapper(null);
            templateConfig.setXml(null);
        } else {
            templateConfig.setService("templates/service.java");
            templateConfig.setServiceImpl("templates/serviceImpl.java");
            templateConfig.setController("templates/controller.java");
            templateConfig.setMapper("templates/mapper.java");
            templateConfig.setXml(null);
        }
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("sys"); //模块名
        pc.setParent(parentPackage);
        pc.setEntity("entity");
        pc.setController("controller");
        pc.setMapper("mapper");
        pc.setService("service");

        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude((include).split(","));//表名，多个英文逗号分割
        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射到实体的命名策略
        strategy.setEntityLombokModel(false);// lombok 模型 @Accessors(chain = true) setter链式操作
        strategy.setRestControllerStyle(true);//restful api风格控制器
        strategy.setControllerMappingHyphenStyle(true);//url中驼峰转连字符
        strategy.setTablePrefix(pc.getModuleName() + "_");//生成实体时去掉表前缀
        mpg.setStrategy(strategy);
        mpg.execute();
    }
}