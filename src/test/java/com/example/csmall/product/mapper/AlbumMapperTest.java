package com.example.csmall.product.mapper;

import com.example.csmall.product.pojo.entity.Album;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AlbumMapperTest {
    @Autowired(required = false)
    AlbumMapper mapper;
    @Test
    void insertTest(){
        Album album = new Album();
        album.setName("测试相册002");
        album.setDescription("测试描述002");
        album.setSort(28);
        int rows = mapper.insert(album);
        System.out.println("项目执行成功,受影响的行数 :" + rows);
    }
}
