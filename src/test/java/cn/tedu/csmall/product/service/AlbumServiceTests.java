package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.pojo.dto.AlbumAddNewDTO;
import cn.tedu.csmall.product.pojo.vo.AlbumListItemVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class AlbumServiceTests {

    @Autowired
    IAlbumService service;

    @Test
    void addNew() {
        AlbumAddNewDTO albumAddNewDTO = new AlbumAddNewDTO();
        albumAddNewDTO.setName("测试数据1");
        albumAddNewDTO.setDescription("测试数据的简介1");
        albumAddNewDTO.setSort(100);

        try {
            service.addNew(albumAddNewDTO);
            log.debug("测试添加数据成功！");
        } catch (ServiceException e) {
            log.debug(e.getMessage());
        }
    }
    @Test
    void delete(){
        Long id=30L;
        try {
            service.delete(id);
            log.debug("测试删除数据成功！");
        } catch (Exception e) {
            log.debug(e.getMessage());
        }
    }

    @Test
    void list(){
        List<AlbumListItemVO> list = service.list();
        for (AlbumListItemVO l:list
             ) {
            System.out.println(l);
        }
    }

}
