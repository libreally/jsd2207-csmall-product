package cn.tedu.csmall.product.controller;


import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.pojo.dto.AlbumAddNewDTO;
import cn.tedu.csmall.product.service.IAlbumService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 处理相册请求控制器
 */
@Api
@Slf4j
@RestController
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private IAlbumService albumService;

    public AlbumController() {
        log.debug("创建控制器对象：AlbumController");
    }
    // http://localhost:8080/add-new?name=相册001&description=相册001的简介&sort=199

    @ApiOperation("添加相册")
    @ApiOperationSupport(order = 100)
    @ApiImplicitParam(name = "id" ,value = "相册id",required = true,dataType = "long")
    @RequestMapping( "/add-newAlbum" )
    public String addNew(AlbumAddNewDTO albumAddNewDTO) {
        log.debug("开始处理【添加相册】的请求，参数：{}", albumAddNewDTO);
        albumService.addNew(albumAddNewDTO);
        log.debug("添加数据成功！");
        return "添加相册成功！";
    }
       /* @ExceptionHandler
        public String xxx(ServiceException e) {
            log.debug("处理请求的方法抛出了ServiceException，将统一处理");
            return e.getMessage();
        }

        @RequestMapping("/test")
        public String test() {
            throw new ServiceException("这是一个测试抛出的异常");
        }*/

    // http://localhost:8080/album/9527/delete
    @ApiOperation("根据id删除相册")
    @ApiOperationSupport(order = 201)
    @RequestMapping("/{id:[0-9]+}/delete")
    public String delete1(@PathVariable Long id) {
        String message = "尝试删除id值为【" + id + "】的相册";
        log.debug(message);
        return message;
    }

    // http://localhost:8080/album/9527/delete
    @ApiOperation("[过期]删除相册")
    @ApiOperationSupport(order = 202)
    @RequestMapping("/{name:[a-z]+}/delete")
    public String delete2(@PathVariable String name) {
        String message = "尝试删除id值为【" + name + "】的相册";
        log.debug(message);
        return message;
    }
    // http://localhost:8080/album/9527/delete
    @ApiOperation("[过期]删除相册")
    @ApiOperationSupport(order = 203)
    @RequestMapping("/test+}/delete")
    public String delete3(@PathVariable String test) {
        String message = "尝试删除id值为【" + test + "】的相册";
        log.debug(message);
        return message;
    }

    }
