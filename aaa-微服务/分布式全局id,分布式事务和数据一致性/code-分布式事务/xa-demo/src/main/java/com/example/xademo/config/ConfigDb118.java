package com.example.xademo.config;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;
import javax.transaction.UserTransaction;
import java.io.IOException;

@Configuration
@MapperScan(value = "com.example.xademo.db118.dao",sqlSessionFactoryRef = "sqlSessionFactoryBean118")
public class ConfigDb118 {

    @Bean("db118")
    public DataSource db118(){
        MysqlXADataSource xaDataSource = new MysqlXADataSource();
        xaDataSource.setUser("root");
        xaDataSource.setPassword("rootroot");
        xaDataSource.setUrl("jdbc:mysql://192.168.1.118:3306/xa_118");

        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(xaDataSource);


        return atomikosDataSourceBean;
    }

    @Bean("sqlSessionFactoryBean118")
    public SqlSessionFactoryBean sqlSessionFactoryBean(@Qualifier("db118") DataSource dataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resourceResolver.getResources("mybatis/db118/*.xml"));
        return sqlSessionFactoryBean;
    }

    @Bean("xaTransaction")
    public JtaTransactionManager jtaTransactionManager(){
        UserTransaction userTransaction = new UserTransactionImp();
        UserTransactionManager userTransactionManager = new UserTransactionManager();

        return new JtaTransactionManager(userTransaction,userTransactionManager);
    }

}
