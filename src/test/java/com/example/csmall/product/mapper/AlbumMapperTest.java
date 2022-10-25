package com.example.csmall.product.mapper;

import com.example.csmall.product.pojo.entity.Album;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Slf4j 日志输出
 */
@Slf4j
@SpringBootTest
public class AlbumMapperTest {
    @Autowired
    AlbumMapper mapper;
    @Test
    void insertTest(){
        Album album = new Album();
        album.setName("测试相册007");
        album.setDescription("测试描述007");
        album.setSort(88);
        log.debug("自动获取前 {}",album);
        int rows = mapper.insert(album);
        log.info("项目执行成功,受影响的行数{} :" ,rows);
        log.debug("自动获取后 {}",album);
    }
    @Test
    void insertBatchTest(){
        List<Album> albums  = new ArrayList<>();
        for (int i=1;i<=5;i++){
            Album album = new Album();
            album.setName("测试相册"+i);
            album.setDescription("测试描述"+i);
            album.setSort(i);
            albums.add(album);
        }
        int rows = mapper.insertBatch(albums);
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
}
