package cn.tedu.csmall.product.mapper;

import cn.tedu.csmall.product.pojo.entity.Attribute;
import cn.tedu.csmall.product.pojo.vo.AttributeListVO;
import cn.tedu.csmall.product.pojo.vo.AttributeStanderVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttributeMapper {
    int insert(Attribute attribute);
    int insertBatch(List<Attribute> attributes);
    int deleteById(Long id);
    int deleteByIds(Long[] id);
    int update(Attribute attribute);
    int count();
    int countByName(String name);
    AttributeStanderVO selectById(Long id);
    List<AttributeListVO> list();
}
