package cn.tedu.csmall.product.mapper;




import cn.tedu.csmall.product.pojo.entity.Category;
import cn.tedu.csmall.product.pojo.vo.CategoryListVO;
import cn.tedu.csmall.product.pojo.vo.CategoryStanderVO;
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
    int countByName(String name);
    CategoryStanderVO selectById(Long id);
    List<CategoryListVO> list();
}
