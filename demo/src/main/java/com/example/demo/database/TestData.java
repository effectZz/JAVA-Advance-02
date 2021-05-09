package com.example.demo.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
import java.util.Map;

@Service
public class TestData {
    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void temp() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection.getMetaData().getURL());
        System.out.println(connection.getMetaData().getUserName());
    }

    public void insert(DataSource dataSource, String sql) throws SQLException {
        System.out.println(dataSource.getConnection().getMetaData().getURL());

        try (Connection conn = dataSource.getConnection(); Statement statement = conn.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    @SwAnnotation
    public void query(DataSource dataSource, String sql) throws SQLException {
        System.out.println(dataSource.getConnection().getMetaData().getURL());
        //获取数据库连接
        Connection connection = dataSource.getConnection();
        //获取执行sql语句的执行者对象Statement
        Statement statement = connection.createStatement();
        //执行sql语句,获取结果
        ResultSet resultSet = statement.executeQuery(sql);
        //处理结果
        while(resultSet.next()){
            int age = resultSet.getInt("goods_id");
            String name = resultSet.getString("goods_sku");
            System.out.println(name + "    " + age);
        }
        //释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }

}
