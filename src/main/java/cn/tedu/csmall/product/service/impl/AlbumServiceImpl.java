package cn.tedu.csmall.product.service.impl;

import cn.tedu.csmall.product.ex.ServiceException;
import cn.tedu.csmall.product.mapper.AlbumMapper;
import cn.tedu.csmall.product.pojo.dto.AlbumAddNewDTO;
import cn.tedu.csmall.product.pojo.entity.Album;
import cn.tedu.csmall.product.pojo.vo.AlbumStandardVO;
import cn.tedu.csmall.product.service.IAlbumService;
import cn.tedu.csmall.product.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 处理相册数据的业务实现类
 *
 * @author java@tedu.cn
 * @version 0.0.1
 */
@Slf4j
@Service
public class AlbumServiceImpl implements IAlbumService {

    @Autowired
    private AlbumMapper albumMapper;

    public AlbumServiceImpl() {
        log.debug("创建业务对象:IAlbumServiceImpl");
    }

    @Override
    public void addNew(AlbumAddNewDTO albumAddNewDTO) {
        log.debug("开始处理【添加相册】的业务，参数：{}", albumAddNewDTO);
        // 从参数对象中获取相册名称
        String albumName = albumAddNewDTO.getName();
        // 检查相册名称是否已经被占用（相册表中是否已经存在此名称的数据）
        log.debug("检查相册名称是否已经被占用");
        int count = albumMapper.countByName(albumName);
        if (count > 0) {
            // 是：相册名称已经被占用，添加相册失败，抛出异常
            String message = "添加相册失败，相册名称已经被占用！";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_CONFLICT, message);
        }
        // 否：相册名称没有被占用，则向相册表中插入数据
        log.debug("相册名称没有被占用，将向相册表中插入数据");
        Album album = new Album();
        BeanUtils.copyProperties(albumAddNewDTO, album);
        log.debug("即将插入相册数据：{}", album);
        albumMapper.insert(album);
        log.debug("插入相册数据完成");
    }

    /**
     * 删除相册
     * @param id 根基id删除
     */
    @Override
    public void delete(Long id) {
        log.debug("开始处理【删除相册】的业务，参数：");
        //调用mapper执行查询
        AlbumStandardVO queryResult = albumMapper.getStandardById(id);
        //判断查询结果是否为null
        if (queryResult==null){
            String message="删除失败,尝试访问的数据不存在";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND,message);
        }
        //执行方法删除
        log.debug("即将执行删除,参数:{}",id);
        albumMapper.deleteById(id);
    }

}