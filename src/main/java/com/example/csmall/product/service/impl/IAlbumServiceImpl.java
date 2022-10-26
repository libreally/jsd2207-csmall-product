package com.example.csmall.product.service.impl;

import com.example.csmall.product.pojo.dto.AlbumAddNewDTO;
import com.example.csmall.product.service.IAlbumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 实现处理相册数据接口
 */
@Slf4j
@Service
public class IAlbumServiceImpl implements IAlbumService {
    public IAlbumServiceImpl(){
        log.debug("创建业务对象");
    }

    @Override
    public void addNew(AlbumAddNewDTO albumAddNewDTO) {

    }
}
