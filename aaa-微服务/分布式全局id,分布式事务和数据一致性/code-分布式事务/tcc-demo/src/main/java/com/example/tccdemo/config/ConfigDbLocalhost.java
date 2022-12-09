package com.example.tccdemo.config;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@MapperScan(value = "com.example.tccdemo.dblocalhost.dao",sqlSessionFactoryRef = "factoryBeanlocalhost")
public class ConfigDbLocalhost {

    @Bean("dblocalhost")
    public DataSource dblocalhost() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("rootroot");
        dataSource.setUrl("jdbc:mysql://192.168.1.7:3306/xa_localhost");

        return dataSource;
    }

    @Bean("factoryBeanlocalhost")
    public SqlSessionFactoryBean factoryBean(@Qualifier("dblocalhost") DataSource dataSource) throws IOException {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();

        factoryBean.setDataSource(dataSource);
        ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();

        factoryBean.setMapperLocations(resourceResolver.getResources("mybatis/dblocalhost/*.xml"));
        return factoryBean;
    }

    @Bean("tmlocalhost")
    public PlatformTransactionManager transactionManager(@Qualifier("dblocalhost") DataSource dataSource) {

        return new DataSourceTransactionManager(dataSource);
    }

}
