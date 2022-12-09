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
@MapperScan(value = "com.example.tccdemo.db118.dao",sqlSessionFactoryRef = "factoryBean118")
public class ConfigDb118 {

    @Bean("db118")
    public DataSource db118() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("rootroot");
        dataSource.setUrl("jdbc:mysql://192.168.1.118:3306/xa_118");

        return dataSource;
    }

    @Bean("factoryBean118")
    public SqlSessionFactoryBean factoryBean(@Qualifier("db118") DataSource dataSource) throws IOException {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();

        factoryBean.setDataSource(dataSource);
        ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();

        factoryBean.setMapperLocations(resourceResolver.getResources("mybatis/db118/*.xml"));
        return factoryBean;
    }

    @Bean("tm118")
    public PlatformTransactionManager transactionManager(@Qualifier("db118") DataSource dataSource) {

        return new DataSourceTransactionManager(dataSource);
    }
}
