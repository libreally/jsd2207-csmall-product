package com.example.csmall.product.mapper;

import com.example.csmall.product.pojo.vo.BrandListVO;
import com.example.csmall.product.pojo.vo.BrandStanderVO;
import com.example.csmall.product.pojo.entity.Brand;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandMapper {
    int insert(Brand brand);
    int insertBatch(List<Brand> brands);
    int deleteById(Long id);
    int deleteByIds(Long[] id);
    int update(Brand brand);
    int count();
    BrandStanderVO selectById(Long id);
    List<BrandListVO> list();
}
