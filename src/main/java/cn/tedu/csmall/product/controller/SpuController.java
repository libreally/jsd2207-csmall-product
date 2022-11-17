package cn.tedu.csmall.product.controller;

import cn.tedu.csmall.product.pojo.dto.SpuAddNewDTO;
import cn.tedu.csmall.product.service.ISpuService;
import cn.tedu.csmall.product.web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Api(tags = "08. 添加SPU")
@RequestMapping("/spu")
public class SpuController {
    @Autowired
    private ISpuService spuService;

    public SpuController() {
        log.info("创建控制器对象：SpuController");
    }

    // http://localhost:9080/spu/add-new
    @ApiOperation("添加spu")
    @ApiOperationSupport(order = 100)
    @PostMapping("/add-new")
    public JsonResult<Void> addNew(SpuAddNewDTO spuAddNewDTO) {
        log.debug("开始处理【添加spu】的请求，参数：{}", spuAddNewDTO);
        spuService.addNew(spuAddNewDTO);
        return JsonResult.ok();
    }
}
