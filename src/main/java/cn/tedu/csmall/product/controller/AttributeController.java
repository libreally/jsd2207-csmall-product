package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.mapper.AttributeMapper;
import cn.tedu.csmall.product.pojo.dto.AttributeAddNewDTO;
import cn.tedu.csmall.product.service.IAttributeService;
import cn.tedu.csmall.product.web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@Validated
@RestController
@RequestMapping("/attribute")
@Api(tags = "属性管理模块")
public class AttributeController {
    @Autowired
    private IAttributeService attributeService;

    public AttributeController(){
        log.debug("创建控制器对象：AttributeController");
    }
    @ApiOperation("添加属性")
    @ApiOperationSupport(order = 100)
    @PostMapping("/add-new")
    public JsonResult<Void> addNew(@Valid AttributeAddNewDTO attributeAddNewDTO){
        log.debug("开始处理【添加属性】的请求，参数：{}", attributeAddNewDTO);
        attributeService.addNew(attributeAddNewDTO);
        log.debug("添加属性成功！");
        return JsonResult.ok();
    }
}
