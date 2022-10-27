package cn.tedu.csmall.product.service.impl;


import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.mapper.AttributeTemplateMapper;
import cn.tedu.csmall.product.pojo.dto.AttributeTemplateDTO;
import cn.tedu.csmall.product.pojo.entity.AttributeTemplate;
import cn.tedu.csmall.product.service.IAttributeTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class IAttributeTemplateServiceImpl implements IAttributeTemplateService {
    @Autowired
    private AttributeTemplateMapper attributeTemplateMapper;

    public IAttributeTemplateServiceImpl(){
        log.debug("创建业务对象:IAttributeTemplateServiceImpl");
    }
    @Override
    public void addNew(AttributeTemplateDTO attributeTemplateDTO) {
        log.debug("开始处理【添加属性模板】的业务，参数：{}", attributeTemplateDTO);
        // 从参数对象中获取属性模板名称
        String brandName = attributeTemplateDTO.getName();
        // 检查属性模板名称是否已经被占用（属性模板表中是否已经存在此名称的数据）
        log.debug("检查属性模板名称是否已经被占用");
        int count = attributeTemplateMapper.countByName(brandName);
        if (count > 0) {
            String message="添加属性模板失败,属性模板名称已经被占用";
            // 是：属性模板名称已经被占用，添加属性模板失败，抛出异常
            log.debug(message);
            throw new ServiceException(message);
        }
        // 否：属性模板名称没有被占用，则向属性模板表中插入数据
        log.debug("属性模板名称没有被占用，将向属性模板表中插入数据");
        AttributeTemplate attributeTemplate = new AttributeTemplate();
        // album.getName().toLowerCase();
        BeanUtils.copyProperties(attributeTemplateDTO, attributeTemplate);
        log.debug("即将插入属性模板数据：{}", attributeTemplate);
        attributeTemplateMapper.insert(attributeTemplate);
        log.debug("插入属性模板数据完成");
    }
}
