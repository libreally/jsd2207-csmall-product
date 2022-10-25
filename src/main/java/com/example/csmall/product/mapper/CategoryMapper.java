package com.example.csmall.product.mapper;




import com.example.csmall.product.pojo.entity.Category;
import com.example.csmall.product.pojo.vo.CategoryListVO;
import com.example.csmall.product.pojo.vo.CategoryStanderVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper {
    int insert(Category category);
    int insertBatch(List<Category> categories);
    int deleteById(Long id);
    int deleteByIds(Long[] id);
    int update(Category category);
    int count();
    CategoryStanderVO selectById(Long id);
    List<CategoryListVO> list();
}
