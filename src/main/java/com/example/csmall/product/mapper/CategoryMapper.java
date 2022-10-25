package com.example.csmall.product.mapper;


import com.example.csmall.product.pojo.entity.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryMapper {
    int insert(Category category);
}
