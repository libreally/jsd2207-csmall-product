package com.example.csmall.product.mapper;

import com.example.csmall.product.pojo.entity.Brand;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandMapper {
    int insert(Brand brand);
}
