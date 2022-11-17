package cn.tedu.csmall.product.service.impl;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.mapper.*;
import cn.tedu.csmall.product.pojo.dto.SpuAddNewDTO;
import cn.tedu.csmall.product.pojo.entity.Spu;
import cn.tedu.csmall.product.pojo.entity.SpuDetail;
import cn.tedu.csmall.product.pojo.vo.AlbumStandardVO;
import cn.tedu.csmall.product.pojo.vo.BrandStandardVO;
import cn.tedu.csmall.product.pojo.vo.CategoryStandardVO;
import cn.tedu.csmall.product.service.ISpuService;
import cn.tedu.csmall.product.util.IdUtils;
import cn.tedu.csmall.product.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SpuServiceImpl implements ISpuService {

    @Autowired
    private SpuMapper spuMapper;
    @Autowired
    private SpuDetailMapper spuDetailMapper;
    @Autowired
    private BrandMapper brandMapper;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private AlbumMapper albumMapper;


    public SpuServiceImpl() {
        log.debug("创建业务对象：SpuServiceImpl");
    }


    @Override
    public void addNew(SpuAddNewDTO spuAddNewDTO) {
        log.debug("开始处理添加spu业务");
        // 根据相册id查询详情，检查是否存在
        log.debug("根据相册id查询详情");
        AlbumStandardVO album = albumMapper.getStandardById(spuAddNewDTO.getAlbumId());
        if (album == null) {
            String message = "添加失败，尝试访问的相册数据不存在!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_NOT_ALBUM, message);
        }
        log.debug("根据品牌id查询详情");
        // 根据品牌id查询详情，检查是否存在
        BrandStandardVO brand = brandMapper.getStandardById(spuAddNewDTO.getBrandId());
        if (brand == null) {
            String message = "添加失败，尝试访问的品牌数据不存在!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_NOT_BRAND, message);
        }
        log.debug("检查品牌是否已经被禁用");
        // 检查品牌是否已经被禁用
        if (brand.getEnable() == 0) {
            String message = "添加失败,该品牌已禁用";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_CONFLICT, message);
        }
        log.debug("根据类别id查询详情");
        // 根据类别id查询详情，检查是否存在
        CategoryStandardVO category = categoryMapper.getStandardById(spuAddNewDTO.getCategoryId());
        if (category == null) {
            String message = "添加失败，尝试访问的类别数据不存在!";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_NOT_CATEGORY, message);
        }
        log.debug("检查类别是否已经被禁用");
        // 检查类别是否已经被禁用
        if (category.getEnable() == 0) {
            String message = "添加失败,该类别已禁用";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_CONFLICT, message);
        }
        log.debug("检查类别是否没有子级");
        // 检查类别是否没有子级
        if (category.getIsParent() == 1) {
            String message = "添加失败,该类别包含子级类别";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_CONFLICT, message);
        }
        log.debug("创建Spu对象，并将参数对象的属性复制过来");
        // 创建Spu对象，并将参数对象的属性复制过来
        Spu spu = new Spu();
        BeanUtils.copyProperties(spuAddNewDTO,spu);
        // 补全Spu对象的属性：ID >>> IdUtils.getId()
        long spuID = IdUtils.getId();
        spu.setId(spuID);
        // 补全Spu对象的属性：brandName >>> 前序检查时的查询结果
        spu.setBrandName(brand.getName());
        // 补全Spu对象的属性：categoryName >>> 前序检查时的查询结果
        spu.setCategoryName(category.getName());
        // 补全Spu对象的属性：sales / commentCount / positiveCommentCount >>> 0
        spu.setSales(0);
        spu.setCommentCount(0);
        spu.setPositiveCommentCount(0);
        // 补全Spu对象的属性：isDeleted / isPublished / isChecked >>> 0
        spu.setIsDeleted(0);
        spu.setIsPublished(0);
        spu.setIsChecked(0);
        // 补全Spu对象的属性：isNewArrival / isRecommend >>> 1（可自行决定）
        spu.setIsNewArrival(1);
        spu.setIsRecommend(1);
        // 插入Spu数据，获取返回结果并检查
        log.debug("插入Spu数据，获取返回结果并检查");
        int rows = spuMapper.insert(spu);
        if (rows!=1){
            String message = "添加spu失败，服务器忙，请稍后再尝试！";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_INSERT, message);
        }

        log.debug("创建SpuDetail对象");
        // 创建SpuDetail对象
        SpuDetail spuDetail = new SpuDetail();
        // 补全SpuDetail对象的属性：spuId >>> 以上Spu使用的ID
        spuDetail.setSpuId(spuID);
        // 补全SpuDetail对象的属性：detail >>> 来自参数对象
        spuDetail.setDetail(spuAddNewDTO.getDetail());
        // 插入SpuDetail数据，获取返回结果并检查
        log.debug("插入SpuDetail数据，获取返回结果并检查");
        rows = spuDetailMapper.insert(spuDetail);
        if (rows!=1){
            String message = "添加spu失败，服务器忙，请稍后再尝试！";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_INSERT, message);
        }

    }
}
