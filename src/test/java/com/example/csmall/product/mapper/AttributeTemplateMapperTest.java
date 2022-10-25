package com.example.csmall.product.mapper;


import com.example.csmall.product.pojo.entity.AttributeTemplate;
import com.example.csmall.product.pojo.vo.AttributeTemplateListVO;
import com.example.csmall.product.pojo.vo.AttributeTemplateStanderVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
public class AttributeTemplateMapperTest {
    @Autowired
    AttributeTemplateMapper mapper;

    @Test
    void insertTest(){
        AttributeTemplate attributeTemplate = new AttributeTemplate(
                "十九点开会","pinyin","sjk",4, LocalDateTime.now(),LocalDateTime.now()
        );
        int rows = mapper.insert(attributeTemplate);
        log.info("项目执行成功,受影响的行数 :" + rows);
    }
    @Test
    void insertBatchTest(){
        List<AttributeTemplate> categorys  = new ArrayList<>();
        for (int i=1;i<=5;i++){
            AttributeTemplate attributeTemplate = new AttributeTemplate();
            attributeTemplate.setName("测试相册"+i);
            attributeTemplate.setKeywords("测试相册"+i);
            attributeTemplate.setSort(i);
            categorys.add(attributeTemplate);
        }
        int rows = mapper.insertBatch(categorys);
        log.info("项目执行成功,受影响的行数{} :" , rows);
    }
    @Test
    void deleteById(){
        Long id=17L;
        int rows = mapper.deleteById(id);
        log.info("项目执行成功,受影响的行数 {}:" ,rows);
    }
    @Test
    void deleteByIds(){
        Long[] id= {16L,15L};
        int rows = mapper.deleteByIds(id);
        log.info("项目执行成功,受影响的行数 {}:" ,rows);
    }
    @Test
    void updateTest(){
        AttributeTemplate attributeTemplate = new AttributeTemplate();
        attributeTemplate.setId(7L);
        attributeTemplate.setName("测试相册007");
        attributeTemplate.setKeywords("测试描述012");
        attributeTemplate.setSort(88);
        log.debug("自动获取前 {}",attributeTemplate);
        int rows = mapper.update(attributeTemplate);
        log.info("项目执行成功,受影响的行数{} :" ,rows);
        log.debug("自动获取后 {}",attributeTemplate);
    }
    @Test
    void count(){
        int count = mapper.count();
        log.info("查询数量 {}" , count);
    }
    @Test
    void getStandardByID(){
        Long id=2L;
        AttributeTemplateStanderVO attributeTemplateStanderVO = mapper.selectById(id);
        log.info( "相册详情{}",attributeTemplateStanderVO);
    }
    @Test
    void list(){
        List<AttributeTemplateListVO> list = mapper.list();
        log.debug("{}",list.size());
        for (AttributeTemplateListVO brandListVO : list) {
            log.info( "相册详情{}",brandListVO);
        }
    }
}
