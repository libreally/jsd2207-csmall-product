package com.example.csmall.product.mapper;

import com.example.csmall.product.pojo.entity.Album;
import com.example.csmall.product.pojo.entity.Brand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class BrandMapperTest {
    @Autowired(required = false)
    BrandMapper mapper;
    @Test
    void insertTest(){
        Brand brand = new Brand("雷神","leishen","暂无","暂无","暂无",
                0,0,0,0,0,
                1,LocalDateTime.now(),LocalDateTime.now());
        mapper.insert(brand);
    }
}
