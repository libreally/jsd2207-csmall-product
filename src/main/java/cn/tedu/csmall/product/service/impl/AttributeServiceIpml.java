package cn.tedu.csmall.product.service.impl;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.mapper.AttributeMapper;
import cn.tedu.csmall.product.pojo.dto.AttributeAddNewDTO;
import cn.tedu.csmall.product.pojo.entity.Album;
import cn.tedu.csmall.product.pojo.entity.Attribute;
import cn.tedu.csmall.product.service.IAttributeService;
import cn.tedu.csmall.product.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AttributeServiceIpml implements IAttributeService {

    @Autowired
    private AttributeMapper attributeMapper;
    public AttributeServiceIpml() {
        log.debug("创建业务对象：AttributeServiceIpml");
    }
    @Override
    public void addNew(AttributeAddNewDTO attributeAddNewDTO) {
        log.debug("开始处理【添加相册】的业务，参数：{}", attributeAddNewDTO);
        // 从参数对象中获取相册名称
        String albumName = attributeAddNewDTO.getName();
        // 检查相册名称是否已经被占用（相册表中是否已经存在此名称的数据）
        log.debug("检查相册名称是否已经被占用");
        int count = attributeMapper.countByName(albumName);
        if (count > 0) {
            // 是：相册名称已经被占用，添加相册失败，抛出异常
            String message = "添加相册失败，相册名称已经被占用！";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_CONFLICT, message);
        }

        // 否：相册名称没有被占用，则向相册表中插入数据
        log.debug("相册名称没有被占用，将向相册表中插入数据");
        Attribute attribute = new Attribute();
        BeanUtils.copyProperties(attributeAddNewDTO,attribute );
        log.debug("即将插入相册数据：{}", attribute);
        int rows = attributeMapper.insert(attribute);
        if (rows != 1) {
            String message = "添加相册失败，服务器忙，请稍后再尝试！";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_INSERT, message);
        }
        log.debug("插入相册数据完成");
    }
}
