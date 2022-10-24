package com.example.csmall.product.mapper;

import com.example.csmall.product.pojo.entity.Album;
import com.example.csmall.product.pojo.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class CategoryMapperTest {
    @Autowired(required = false)
    CategoryMapper mapper;

    @Test
    void insertTest(){
        Category category = new Category("热水器", 66L,
                5,"无",0,"无",1,
                0,1, LocalDateTime.now(),LocalDateTime.now());
        mapper.insert(category);
    }
}
