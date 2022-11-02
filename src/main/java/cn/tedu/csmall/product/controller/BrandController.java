package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.pojo.dto.BrandAddNewDTO;
import cn.tedu.csmall.product.pojo.vo.BrandListItemVO;
import cn.tedu.csmall.product.service.IBrandService;
import cn.tedu.csmall.product.web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private IBrandService brandService;
    
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
    @ApiOperation("根据id删除相册")
    @ApiOperationSupport(order = 201)
    @ApiImplicitParam(name = "id", value = "相册id", required = true, dataType = "long")
    @RequestMapping("/{id:[0-9]+}/delete")
    public JsonResult<Void>  delete(@Range(min = 1, message = "删除相册失败，尝试删除的相册的ID无效！")
                                     @PathVariable Long id) {
        log.debug("开始处理[根据id删除相册]的请求,参数:{}",id);
        brandService.delete(id);
        return JsonResult.ok();
    }

    // http://localhost:8080/brand
    @ApiOperation("查询品牌列表")
    @ApiOperationSupport(order = 420)
    @GetMapping("")
    public JsonResult<List<BrandListItemVO>> list() {
        log.debug("开始处理【查询相册列表】的请求，无参数");
        List<BrandListItemVO> list = brandService.list();
        return JsonResult.ok(list);
    }
}
