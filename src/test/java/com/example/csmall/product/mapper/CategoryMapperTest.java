package com.example.csmall.product.mapper;

import com.example.csmall.product.pojo.entity.Album;
import com.example.csmall.product.pojo.entity.Category;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@Slf4j
@SpringBootTest
public class CategoryMapperTest {
    @Autowired
    CategoryMapper mapper;

    @Test
    void insertTest(){
        Category category = new Category("热水器", 66L,
                5,"无",0,"无",1,
                0,1, LocalDateTime.now(),LocalDateTime.now());
        int rows = mapper.insert(category);
        log.info("项目执行成功,受影响的行数 :" + rows);
    }
}
