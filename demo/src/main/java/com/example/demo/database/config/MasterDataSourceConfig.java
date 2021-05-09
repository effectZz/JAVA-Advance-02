//package com.example.demo.database.config;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//
//import org.springframework.context.annotation.Configuration;
//
//import lombok.Data;
//import org.springframework.beans.factory.annotation.Value;
//
//@Configuration
//@ConfigurationProperties(prefix = "datasource.master")
//@Data
//public class MasterDataSourceConfig {
//    @Value("${datasource.master.url}")
//    private String url;
//    @Value("${datasource.master.username}")
//    private String username;
//    @Value("${datasource.master.password}")
//    private String password;
//    @Value("${datasource.master.driverClassName}")
//    private String driverClassName;
//}