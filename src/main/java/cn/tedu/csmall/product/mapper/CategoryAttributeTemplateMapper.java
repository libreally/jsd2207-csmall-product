package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.AttributeTemplate;
import cn.tedu.csmall.product.pojo.entity.CategoryAttributeTemplate;
import cn.tedu.csmall.product.pojo.vo.AttributeTemplateListVO;
import cn.tedu.csmall.product.pojo.vo.AttributeTemplateStanderVO;
import cn.tedu.csmall.product.pojo.vo.CategoryAttributeTemplateListVO;
import cn.tedu.csmall.product.pojo.vo.CategoryAttributeTemplateStanderVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryAttributeTemplateMapper {
    int insert( CategoryAttributeTemplate categoryAttributeTemplate);
    int insertBatch(List<CategoryAttributeTemplate> categoryAttributeTemplates);
    int deleteById(Long id);
    int deleteByIds(Long[] id);
    int update(CategoryAttributeTemplate categoryAttributeTemplate);
    int count();
    int countByName(Long id);
    CategoryAttributeTemplateStanderVO selectById(Long id);
    List<CategoryAttributeTemplateListVO> list();

}
