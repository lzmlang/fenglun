package com.saul.boot.generator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * mysql数据库代码生成器
 *
 * @author jiangjd
 */
public class MysqlGenerator {

    private DataSourceConfig dsc;
    private String parent;


    public MysqlGenerator(DataSourceConfig dsc) {
        this.dsc = dsc;
    }

    public MysqlGenerator(String url, String username, String password) {
        dsc = new DataSourceConfig();
        dsc.setUrl(url);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername(username);
        dsc.setPassword(password);
    }

    public MysqlGenerator(String ip, int port, String dbname, String username, String password) {
        dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://" + ip + ":" + port + "/" + dbname
                + "?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=GMT%2B8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername(username);
        dsc.setPassword(password);
        //类型转换 LocalDateTime转换成Date
        dsc.setTypeConvert(new ITypeConvert() {
            @Override
            public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                String t = fieldType.toLowerCase();
                if(t.contains("timestamp")){
                    return DbColumnType.DATE;
                }
                //其它字段采用默认转换（非mysql数据库可以使用其它默认的数据库转换器）
                return new MySqlTypeConvert().processTypeConvert(globalConfig,fieldType);
            }
        });
    }

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    @SuppressWarnings("resource")
    private String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public void run() {
        boolean run = true;
        while (run) {
            System.out.println("exit退出");
            String modulename = scanner("模块名称");
            if ("exit".equals(modulename)) {
                run = false;
                return;
            }
            String tablename = scanner("表名");
            if ("exit".equals(tablename)) {
                run = false;
                return;
            }
            String author = "";
            run(modulename, tablename, author);
        }
        System.err.println("已经退出");
    }

    public void run(String modulename, String tablename, String author) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        //配置数据源
        mpg.setDataSource(dsc);
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/base_service" + "/src/main/java");
        gc.setAuthor(author);
        gc.setServiceName("%sService");
        gc.setOpen(false);
        gc.setSwagger2(true);
        gc.setIdType(IdType.ID_WORKER);
        gc.setDateType(DateType.TIME_PACK);
        mpg.setGlobalConfig(gc);
        // 包配置
        PackageConfig pc = new PackageConfig();
        //pc.setModuleName(modulename);
        if (parent == null) parent = "com.nsc.boot.platform.modules";
        pc.setParent(parent);
        pc.setXml("mapper.xml");
        mpg.setPackageInfo(pc);
        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("eic", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };
        mpg.setCfg(cfg);
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperEntityClass("com.nsc.boot.platform.entity.TBaseEntity");
//        strategy.setSuperServiceClass("com.nsc.boot.common.mybatis.service.IBaseService");
//
//        strategy.setSuperServiceImplClass("com.nsc.boot.common.mybatis.service.impl.BaseServiceImpl");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setTablePrefix(new String[]{"t_", ""});// 此处可以修改为您的表前缀
//        strategy.setSuperControllerClass("com.nsc.boot.common.controller.BaseController");
        String[] split = tablename.split(",");
        strategy.setInclude(split);
//        strategy.setSuperEntityColumns("id", "creater_id", "create_date", "modifier_id", "modify_date", "is_deleted");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setLogicDeleteFieldName("is_deleted");// 逻辑删除属性名称
        strategy.setEntityBooleanColumnRemoveIsPrefix(true);
        // strategy.setTablePrefix(pc.admingetModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
}
