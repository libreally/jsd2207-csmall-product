package com.example.csmall.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class Jsd2207CsmallProductApplicationTests {
    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() {
    }

    @Test
    void getConnection () throws SQLException {
        dataSource.getConnection();
    }

}
