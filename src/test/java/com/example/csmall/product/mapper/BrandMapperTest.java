package com.example.csmall.product.mapper;

import com.example.csmall.product.pojo.entity.Album;
import com.example.csmall.product.pojo.entity.Brand;
import com.example.csmall.product.pojo.vo.AlbumListItemVO;
import com.example.csmall.product.pojo.vo.AlbumStandardVO;
import com.example.csmall.product.pojo.vo.BrandListVO;
import com.example.csmall.product.pojo.vo.BrandStanderVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
public class BrandMapperTest {
    @Autowired
    BrandMapper mapper;
    @Test
    void insertTest(){
        Brand brand = new Brand("雷神","leishen","暂无","暂无","暂无",
                0,0,0,0,0,
                1,LocalDateTime.now(),LocalDateTime.now());
        int rows = mapper.insert(brand);
        log.info("项目执行成功,受影响的行数 :" + rows);
    }
    @Test
    void insertBatchTest(){
        List<Brand> brands  = new ArrayList<>();
        for (int i=1;i<=5;i++){
            Brand brand = new Brand();
            brand.setName("测试相册"+i);
            brand.setPinyin("测试描述"+i);
            brand.setSort(i);
            brands.add(brand);
        }
        int rows = mapper.insertBatch(brands);
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
        Brand brand = new Brand();
        brand.setId(7L);
        brand.setName("测试相册007");
        brand.setDescription("测试描述012");
        brand.setSort(88);
        log.debug("自动获取前 {}",brand);
        int rows = mapper.update(brand);
        log.info("项目执行成功,受影响的行数{} :" ,rows);
        log.debug("自动获取后 {}",brand);
    }
    @Test
    void count(){
        int count = mapper.count();
        log.info("查询数量 {}" , count);
    }
    @Test
    void getStandardByID(){
        Long id=2L;
        BrandStanderVO brandStanderVO = mapper.selectById(id);
        log.info( "相册详情{}",brandStanderVO);
    }
    @Test
    void list(){
        List<BrandListVO> list = mapper.list();
        log.debug("{}",list.size());
        for (BrandListVO brandListVO : list) {
            log.info( "相册详情{}",brandListVO);
        }
    }
}
