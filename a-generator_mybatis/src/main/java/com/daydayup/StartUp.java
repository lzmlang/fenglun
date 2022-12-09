package com.daydayup;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 〈〉<br>
 *
 * @author luo_zm
 * @company
 * @create 2019/10/26  14:30
 * @since 1.0.0
 */
public class StartUp {
  public static void main(String[] args) throws URISyntaxException {
    try {
      System.out.println("--------------------start generator-------------------");
      List<String> warnings = new ArrayList<String>();
      boolean overwrite = true;
      ClassLoader classloader = Thread.currentThread().getContextClassLoader();
      InputStream is = classloader.getResourceAsStream("generatorConfig02.xml");
      ConfigurationParser cp = new ConfigurationParser(warnings);
      Configuration config = cp.parseConfiguration(is);
      DefaultShellCallback callback = new DefaultShellCallback(overwrite);
      MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
      myBatisGenerator.generate(null);
      System.out.println("--------------------end generator-------------------");
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (InvalidConfigurationException e) {
      e.printStackTrace();
    } catch (XMLParserException e) {
      e.printStackTrace();
    }
  }
  public void generator() throws Exception {

    List<String> warnings = new ArrayList<String>();
    boolean overwrite = true;
    // 指定 逆向工程配置文件
    File configFile = new File("F:\\ideaworkspace\\myself\\java_bases\\generator_mybatis\\src\\main\\resources\\generatorConfig02.xml");
    ConfigurationParser cp = new ConfigurationParser(warnings);
    Configuration config = cp.parseConfiguration(configFile);
    DefaultShellCallback callback = new DefaultShellCallback(overwrite);
    MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
    myBatisGenerator.generate(null);

  }
}
