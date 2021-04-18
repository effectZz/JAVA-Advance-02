package com.practice.no10.hikari;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class HikariConfigTest {

    @Bean
    public DataSource dataSource() throws SQLException {
        HikariConfig config = new HikariConfig("/hikari.properties");
        return new HikariDataSource(config);
    }
}
