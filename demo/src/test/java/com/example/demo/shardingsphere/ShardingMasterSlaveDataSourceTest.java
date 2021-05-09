package com.example.demo.shardingsphere;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ShardingMasterSlaveDataSourceTest {

    @Autowired
    ShardingMasterSlaveDataSource shardingMasterSlaveDataSource;

    @Test
    public void test() throws SQLException {
        DataSource dataSource = shardingMasterSlaveDataSource.createDataSource();
        log.info("ShardingMasterSlaveDataSource info::" + dataSource.getConnection().getMetaData().getURL());

        Connection conn = dataSource.getConnection();
        Statement statement = conn.createStatement();

        String sql = "SELECT goods_id,goods_sku FROM mall_t_goods";
        statement.execute(sql);

        sql = "INSERT INTO demo_trade.mall_t_goods (goods_id, goods_sku, goods_spu, class_name, goods_name, brand, goods_len, goods_width, goods_height, weight, spec_name) VALUES (99, '1', '1', '1', '1', '1', 1, 1, 1, 1, '1')";
        statement.execute(sql);

        sql = "SELECT goods_id,goods_sku FROM mall_t_goods";
        statement.execute(sql);
    }
}