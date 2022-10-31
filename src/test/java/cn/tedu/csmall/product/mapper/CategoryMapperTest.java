package cn.tedu.csmall.product.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    @Test
    void insertBatchTest(){
        List<Category> categorys  = new ArrayList<>();
        for (int i=1;i<=5;i++){
            Category category = new Category();
            category.setName("测试相册"+i);
            category.setKeywords("测试相册"+i);
            category.setSort(i);
            categorys.add(category);
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
        Category category = new Category();
        category.setId(7L);
        category.setName("测试相册007");
        category.setKeywords("测试描述012");
        category.setSort(88);
        log.debug("自动获取前 {}",category);
        int rows = mapper.update(category);
        log.info("项目执行成功,受影响的行数{} :" ,rows);
        log.debug("自动获取后 {}",category);
    }
    @Test
    void count(){
        int count = mapper.count();
        log.info("查询数量 {}" , count);
    }
    @Test
    void getStandardByID(){
        Long id=2L;
        CategoryStanderVO categoryStanderVO = mapper.selectById(id);
        log.info( "相册详情{}",categoryStanderVO);
    }
    @Test
    void list(){
        List<CategoryListVO> list = mapper.list();
        log.debug("{}",list.size());
        for (CategoryListVO brandListVO : list) {
            log.info( "相册详情{}",brandListVO);
        }
    }
}
