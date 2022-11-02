package cn.tedu.csmall.product.controller;


import cn.tedu.csmall.product.pojo.dto.AlbumAddNewDTO;
import cn.tedu.csmall.product.pojo.vo.AlbumListItemVO;
import cn.tedu.csmall.product.service.IAlbumService;
import cn.tedu.csmall.product.web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 处理相册请求控制器
 */

@Slf4j
@Validated
@RestController
@RequestMapping("/album")
@Api(tags = "04. 相册管理模块")
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
    public JsonResult<Void>  addNew(@Valid AlbumAddNewDTO albumAddNewDTO) {
        log.debug("开始处理【添加相册】的请求，参数：{}", albumAddNewDTO);
        albumService.addNew(albumAddNewDTO);
        log.debug("添加数据成功！");
        return JsonResult.ok();
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

    @ApiOperation("根据id删除相册")
    @ApiOperationSupport(order = 201)
    @ApiImplicitParam(name = "id", value = "相册id", required = true, dataType = "long")
    @RequestMapping("/{id:[0-9]+}/delete")
    public JsonResult<Void>  delete1(@Range(min = 1, message = "删除相册失败，尝试删除的相册的ID无效！")
                              @PathVariable Long id) {
        log.debug("开始处理[根据id删除相册]的请求,参数:{}",id);
        albumService.delete(id);
        return JsonResult.ok();
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

    // http://localhost:8080/albums
    @ApiOperation("查询相册列表")
    @ApiOperationSupport(order = 420)
    @GetMapping("")
    public JsonResult<List<AlbumListItemVO>> list() {
        log.debug("开始处理【查询相册列表】的请求，无参数");
        List<AlbumListItemVO> list = albumService.list();
        return JsonResult.ok(list);
    }
}
