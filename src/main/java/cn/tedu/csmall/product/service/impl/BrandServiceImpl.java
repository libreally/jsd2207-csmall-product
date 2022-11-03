package cn.tedu.csmall.product.service.impl;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.mapper.BrandMapper;
import cn.tedu.csmall.product.pojo.dto.BrandAddNewDTO;
import cn.tedu.csmall.product.pojo.entity.Brand;
import cn.tedu.csmall.product.pojo.vo.AlbumListItemVO;
import cn.tedu.csmall.product.pojo.vo.BrandListItemVO;
import cn.tedu.csmall.product.pojo.vo.BrandStandardVO;
import cn.tedu.csmall.product.service.IBrandService;
import cn.tedu.csmall.product.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 处理品牌业务的实现类
 *
 * @author java@tedu.cn
 * @version 0.0.1
 */
@Slf4j
@Service
public class BrandServiceImpl implements IBrandService {

    @Autowired
    private BrandMapper brandMapper;

    public BrandServiceImpl() {
        log.info("创建业务对象：BrandServiceImpl");
    }

    @Override
    public void addNew(BrandAddNewDTO brandAddNewDTO) {
        log.debug("开始处理【添加品牌】的业务，参数：{}", brandAddNewDTO);
        // 检查品牌名称是否已经被占用
        String name = brandAddNewDTO.getName();
        int countByName = brandMapper.countByName(name);
        log.debug("尝试添加的品牌名称是：{}，在数据库中此名称的品牌数量为：{}", name, countByName);
        if (countByName > 0) {
            String message = "添加品牌失败，品牌名称【" + brandAddNewDTO.getName() + "】已经被占用！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERR_CONFLICT, message);
        }

        // 创建品牌对象，用于插入到数据表
        Brand brand = new Brand();
        BeanUtils.copyProperties(brandAddNewDTO, brand);
        // 插入数据
        log.debug("即将向数据库中插入数据：{}", brand);
        int rows=brandMapper.insert(brand);
        if (rows != 1) {
            String message = "添加类别失败，服务器忙，请稍后再尝试！";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_INSERT, message);
        }
    }

    @Override
    public void delete(Long id){
        log.debug("开始处理【根据id删除品牌】的业务，参数：{}", id);
        BrandStandardVO standardById = brandMapper.getStandardById(id);
        if (standardById==null){
            String message="删除失败,尝试访问的数据不存在";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND,message);
        }
        log.debug("即将执行删除业务,参数{}",id);
        brandMapper.deleteById(id);
    }

    @Override
    public List<BrandListItemVO> list(){
        log.debug("开始处理[查询相册列表]的业务,无参数");
        return brandMapper.list();
    }

}
