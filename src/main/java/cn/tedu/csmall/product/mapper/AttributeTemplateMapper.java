package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.AttributeTemplate;
import cn.tedu.csmall.product.pojo.vo.AttributeTemplateListVO;
import cn.tedu.csmall.product.pojo.vo.AttributeTemplateStanderVO;
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
    int countByName(String name);
    AttributeTemplateStanderVO selectById(Long id);
    List<AttributeTemplateListVO> list();

}
