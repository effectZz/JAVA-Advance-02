package com.example.demo.database.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
//    @Resource
//    private MasterDataSourceConfig masterDataSourceConfig;
//    @Resource
//    private SlaveDataSourceConfig slaveDataSourceConfig;
//    @Primary
//    @Bean(name = "master")
//    public DataSource masterDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUrl(masterDataSourceConfig.getUrl());
//        dataSource.setUsername(masterDataSourceConfig.getUsername());
//        dataSource.setPassword(masterDataSourceConfig.getPassword());
//        dataSource.setDriverClassName(masterDataSourceConfig.getDriverClassName());
//        return dataSource;
//    }
//    @Bean(name = "slave")
//    public DataSource slaveDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUrl(slaveDataSourceConfig.getUrl());
//        dataSource.setUsername(slaveDataSourceConfig.getUsername());
//        dataSource.setPassword(slaveDataSourceConfig.getPassword());
//        dataSource.setDriverClassName(slaveDataSourceConfig.getDriverClassName());
//        return dataSource;
//    }

//    @Primary//不加这个会报错。
//    @DependsOn({ "master", "slave"}) //解决数据库循环依赖问题
//    @Bean(name = "multiDataSource")
//    public MultiRouteDataSource exampleRouteDataSource() {
//        MultiRouteDataSource multiDataSource = new MultiRouteDataSource();
//        Map<Object, Object> targetDataSources = new HashMap<>();
//        targetDataSources.put("master", masterDataSource());
//        targetDataSources.put("slave", slaveDataSource());
//        multiDataSource.setTargetDataSources(targetDataSources);
//        multiDataSource.setDefaultTargetDataSource(masterDataSource());
//        return multiDataSource;
//    }

    @Autowired
    private Environment env;

    @Primary
    @Bean(name = "master")
    public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty("datasource.master.url"));
        dataSource.setUsername(env.getProperty("datasource.master.username"));
        dataSource.setPassword(env.getProperty("datasource.master.password"));
        return dataSource;
    }

    @Bean(name = "slave")
    public DataSource getSlaveSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty("datasource.slave.url"));
        dataSource.setUsername(env.getProperty("datasource.slave.username"));
        dataSource.setPassword(env.getProperty("datasource.slave.password"));
        return dataSource;
    }
}