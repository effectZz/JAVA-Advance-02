package com.example.demo.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class ManagementCenter {

    @Autowired
    @Qualifier("master")
    DataSource masterDataSource;

    @Autowired
    @Qualifier("slave")
    DataSource slave1DataSource;

    public DataSource getMasterDataSource() {
        return masterDataSource;
    }


    public DataSource getSlaveDataSource() {
        return slave1DataSource;
    }
}
