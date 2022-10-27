package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.pojo.dto.BrandAddNewDTO;
import cn.tedu.csmall.product.service.IBrandService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    IBrandService brandService;
    
    public BrandController(){
        log.debug("创建控制器对象：BrandController");
    }

    @ApiOperation("添加相册")
    @ApiOperationSupport(order = 100)
    @RequestMapping("/add-newBrand")
    public String addNew(BrandAddNewDTO brandAddNewDTO){
        log.debug("开始处理【添加商品】的请求，参数：{}", brandAddNewDTO);
        try {
            brandService.addNew(brandAddNewDTO);
            log.debug("添加数据成功！");
            return "添加商品成功！";
        } catch (ServiceException e) {
            String message=e.getMessage();
            log.debug(message);
            return message;
        } catch (RuntimeException e) {
            log.debug("添加数据失败！程序运行过程中出现了RuntimeException！");
            return "添加商品失败！程序运行过程中出现了RuntimeException！";
        } catch (Throwable e) {
            log.debug("添加数据失败！程序运行过程中出现了Throwable！");
            return "添加商品失败！程序运行过程中出现了Throwable！";
        }
    }
}
