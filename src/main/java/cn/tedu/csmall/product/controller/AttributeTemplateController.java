package cn.tedu.csmall.product.controller;


import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.pojo.dto.AttributeTemplateAddNewDTO;
import cn.tedu.csmall.product.pojo.vo.AttributeTemplateListItemVO;
import cn.tedu.csmall.product.service.IAttributeTemplateService;

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
@RequestMapping("/AttributeTemplate")
public class AttributeTemplateController {
    @Autowired
    private IAttributeTemplateService attributeTemplateService;
    public AttributeTemplateController() { log.debug("创建控制器对象：AttributeTemplateController"); }

    @ApiOperation("添加相册")
    @ApiOperationSupport(order = 100)
    @RequestMapping("/add-new")
    public String addNew(AttributeTemplateAddNewDTO attributeTemplateAddNewDTO){
        log.debug("开始处理【添加属性模板】的请求，参数：{}", attributeTemplateAddNewDTO);
        try {
            attributeTemplateService.addNew(attributeTemplateAddNewDTO);
            log.debug("添加数据成功！");
            return "添加属性模板成功！";
        } catch (ServiceException e) {
            String message=e.getMessage();
            log.debug(message);
            return message;
        } catch (RuntimeException e) {
            log.debug("添加数据失败！程序运行过程中出现了RuntimeException！");
            return "添加属性模板失败！程序运行过程中出现了RuntimeException！";
        } catch (Throwable e) {
            log.debug("添加数据失败！程序运行过程中出现了Throwable！");
            return "添加属性模板失败！程序运行过程中出现了Throwable！";
        }
    }
    @ApiOperation("根据id删除相册")
    @ApiOperationSupport(order = 201)
    @ApiImplicitParam(name = "id", value = "相册id", required = true, dataType = "long")
    @RequestMapping("/{id:[0-9]+}/delete")
    public JsonResult<Void> delete1(@Range(min = 1, message = "删除属性模板失败，尝试删除的相册的ID无效！")
                                     @PathVariable Long id) {
        log.debug("开始处理[根据id删除相册]的请求,参数:{}",id);
        attributeTemplateService.delete(id);
        return JsonResult.ok();
    }

    @ApiOperation("查询相册列表")
    @ApiOperationSupport(order = 420)
    @GetMapping("")
    public JsonResult<List<AttributeTemplateListItemVO>> list() {
        log.debug("开始处理【查询相册列表】的请求，无参数");
        List<AttributeTemplateListItemVO> list = attributeTemplateService.list();
        return JsonResult.ok(list);
    }
}