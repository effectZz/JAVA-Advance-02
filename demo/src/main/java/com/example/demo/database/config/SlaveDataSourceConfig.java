//package com.example.demo.database.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Configuration;
//
//import lombok.Data;
//
//
//@Configuration
//@ConfigurationProperties(prefix = "datasource.slave")
//@Data
//public class SlaveDataSourceConfig {
//    @Value("${datasource.slave.url}")
//    private String url;
//    @Value("${datasource.slave.username}")
//    private String username;
//    @Value("${datasource.slave.password}")
//    private String password;
//    @Value("${datasource.slave.driverClassName}")
//    private String driverClassName;
//}