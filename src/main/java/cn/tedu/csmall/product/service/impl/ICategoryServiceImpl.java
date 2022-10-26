package cn.tedu.csmall.product.service.impl;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.mapper.CategoryMapper;
import cn.tedu.csmall.product.pojo.dto.CategoryAddNewDTO;
import cn.tedu.csmall.product.pojo.entity.Brand;
import cn.tedu.csmall.product.pojo.entity.Category;
import cn.tedu.csmall.product.service.ICategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ICategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    
    public ICategoryServiceImpl(){
        log.debug("创建业务对象:ICategoryServiceImpl");
    }

    @Override
    public void addNew(CategoryAddNewDTO categoryAddNewDTO) {
        log.debug("开始处理【添加分类】的业务，参数：{}", categoryAddNewDTO);
        String categoryName = categoryAddNewDTO.getName();
        log.debug("检查分类名称是否已经被占用");
        int count = categoryMapper.countByName(categoryName);
        if (count>0){
            String message="添加分类失败,分类名称已经被占用";
            // 是：分类名称已经被占用，添加分类失败，抛出异常
            log.debug(message);
            throw new ServiceException(message);
        }
        // 否：分类名称没有被占用，则向分类表中插入数据
        log.debug("分类名称没有被占用，将向分类表中插入数据");
        Category category = new Category();
        // album.getName().toLowerCase();
        BeanUtils.copyProperties(categoryAddNewDTO, category);
        log.debug("即将插入分类数据：{}", category);
        categoryMapper.insert(category);
        log.debug("插入分类数据完成");
    }
}
