package com.example.demo.database;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.SQLException;
import java.util.Random;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class TestDataTest {

    @Autowired
    ManagementCenter dataSourceCenter;
    @Autowired
    TestData testData;

    @Test
    public void test() throws SQLException {
        int id = new Random().nextInt(100+100);
        String sql = "INSERT INTO demo_trade.mall_t_goods (goods_id, goods_sku, goods_spu, class_name, goods_name, brand, goods_len, goods_width, goods_height, weight, spec_name) VALUES ("+id+", '1', '1', '1', '1', '1', 1, 1, 1, 1, '1')";
        testData.insert(dataSourceCenter.getMasterDataSource(),sql);

        testData.query(dataSourceCenter.getSlaveDataSource(),"SELECT goods_id,goods_sku FROM mall_t_goods");



    }
}