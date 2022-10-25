package com.example.csmall.product.mapper;

import com.example.csmall.product.pojo.entity.AttributeTemplate;
import com.example.csmall.product.pojo.vo.AttributeTemplateListVO;
import com.example.csmall.product.pojo.vo.AttributeTemplateStanderVO;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AttributeTemplateMapper {
    int insert( AttributeTemplate attributeTemplate);
    int insertBatch(List<AttributeTemplate> attributeTemplates);
    int deleteById(Long id);
    int deleteByIds(Long[] id);
    int update(AttributeTemplate attributeTemplate);
    int count();
    AttributeTemplateStanderVO selectById(Long id);
    List<AttributeTemplateListVO> list();

}
