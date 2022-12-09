package com.example.xademo.config;

import com.mysql.cj.jdbc.MysqlXADataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@MapperScan(value = "com.example.xademo.dblocalhost.dao",sqlSessionFactoryRef = "sqlSessionFactoryBeanlocalhost")
public class ConfigDbLocalhost {

    @Bean("dblocalhost")
    public DataSource dblocalhost(){
        MysqlXADataSource xaDataSource = new MysqlXADataSource();
        xaDataSource.setUser("root");
        xaDataSource.setPassword("rootroot");
        xaDataSource.setUrl("jdbc:mysql://192.168.1.7:3306/xa_localhost");

        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(xaDataSource);


        return atomikosDataSourceBean;
    }

    @Bean("sqlSessionFactoryBeanlocalhost")
    public SqlSessionFactoryBean sqlSessionFactoryBean(@Qualifier("dblocalhost") DataSource dataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resourceResolver.getResources("mybatis/dblocalhost/*.xml"));
        return sqlSessionFactoryBean;
    }



}
