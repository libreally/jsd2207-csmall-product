package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.BrandCategory;
import cn.tedu.csmall.product.pojo.vo.BrandCategoryListVO;
import cn.tedu.csmall.product.pojo.vo.BrandCategoryStanderVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandCategoryMapper {
    int insert(BrandCategory BrandCategory);
    int insertBatch(List<BrandCategory> BrandCategorys);
    int deleteById(Long id);
    int deleteByIds(Long[] id);
    int update(BrandCategory BrandCategory);
    int count();
    int countByName(Long id);
    BrandCategoryStanderVO selectById(Long id);
    List<BrandCategoryListVO> list();
}
