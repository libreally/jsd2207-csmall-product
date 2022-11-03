package cn.tedu.csmall.product.controller;


import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.pojo.dto.CategoryAddNewDTO;
import cn.tedu.csmall.product.service.ICategoryService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    public CategoryController() {
        log.debug("创建控制器对象：CategoryController");
    }

    @ApiOperation("添加类别")
    @ApiOperationSupport(order = 100)
    @RequestMapping("/add-newCategory" )
    public String addNew(CategoryAddNewDTO categoryAddNewDTO) {
        log.debug("开始处理分类请求，参数：{}", categoryAddNewDTO);

        try {
            categoryService.addNew(categoryAddNewDTO);

            log.debug("添加数据成功！");
            return "添加分类成功！";
        } catch (ServiceException e) {
            String message = e.getMessage();
            log.debug(message);
            return message;
        } catch (RuntimeException e) {
            log.debug("添加数据失败！程序运行过程中出现了RuntimeException！");
            return "添加分类失败！程序运行过程中出现了RuntimeException！";
        } catch (Throwable e) {
            log.debug("添加数据失败！程序运行过程中出现了Throwable！");
            return "添加分类失败！程序运行过程中出现了Throwable！";
        }
    }
}
