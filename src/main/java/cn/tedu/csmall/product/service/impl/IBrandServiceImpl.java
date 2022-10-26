package cn.tedu.csmall.product.service.impl;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.mapper.BrandMapper;
import cn.tedu.csmall.product.pojo.dto.BrandAddNewDTO;
import cn.tedu.csmall.product.pojo.entity.Brand;
import cn.tedu.csmall.product.service.IBrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class IBrandServiceImpl implements IBrandService {

    @Autowired
    private BrandMapper brandMapper;
    
    public IBrandServiceImpl(){
        log.debug("创建业务对象:IBrandServiceImpl");
    }
    
    @Override
    public void addNew(BrandAddNewDTO brandAddNewDTO) {
        log.debug("开始处理【添加商品】的业务，参数：{}", brandAddNewDTO);
        // 从参数对象中获取商品名称
        String brandName = brandAddNewDTO.getName();
        // 检查商品名称是否已经被占用（商品表中是否已经存在此名称的数据）
        log.debug("检查商品名称是否已经被占用");
        int count = brandMapper.countByName(brandName);
        if (count > 0) {
            String message="添加商品失败,商品名称已经被占用";
            // 是：商品名称已经被占用，添加商品失败，抛出异常
            log.debug(message);
            throw new ServiceException(message);
        }
        // 否：商品名称没有被占用，则向商品表中插入数据
        log.debug("商品名称没有被占用，将向商品表中插入数据");
        Brand brand = new Brand();
        // album.getName().toLowerCase();
        BeanUtils.copyProperties(brandAddNewDTO, brand);
        log.debug("即将插入商品数据：{}", brand);
        brandMapper.insert(brand);
        log.debug("插入商品数据完成");
    }
}
