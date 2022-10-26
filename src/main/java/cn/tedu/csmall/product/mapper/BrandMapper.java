package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Brand;
import cn.tedu.csmall.product.pojo.vo.BrandListVO;
import cn.tedu.csmall.product.pojo.vo.BrandStanderVO;
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
