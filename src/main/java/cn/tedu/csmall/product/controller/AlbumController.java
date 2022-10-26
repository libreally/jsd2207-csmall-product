package cn.tedu.csmall.product.controller;


import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.pojo.dto.AlbumAddNewDTO;
import cn.tedu.csmall.product.service.IAlbumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 处理相册请求控制器
 */
@Slf4j
@RestController
public class AlbumController {
    @Autowired
    private IAlbumService albumService;

    public AlbumController(){
        log.debug("创建控制器对象：AlbumController");
    }
    // http://localhost:8080/add-new?name=相册001&description=相册001的简介&sort=199

    @RequestMapping("/add-newAlbum")
    public String addNew(AlbumAddNewDTO albumAddNewDTO){
        log.debug("开始处理【添加相册】的请求，参数：{}", albumAddNewDTO);
        try {
            albumService.addNew(albumAddNewDTO);
            log.debug("添加数据成功！");
            return "添加相册成功！";
        } catch (ServiceException e) {
            String message=e.getMessage();
            log.debug(message);
            return message;
        } catch (RuntimeException e) {
            log.debug("添加数据失败！程序运行过程中出现了RuntimeException！");
            return "添加相册失败！程序运行过程中出现了RuntimeException！";
        } catch (Throwable e) {
            log.debug("添加数据失败！程序运行过程中出现了Throwable！");
            return "添加相册失败！程序运行过程中出现了Throwable！";
        }
    }

}