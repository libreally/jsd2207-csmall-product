package com.example.csmall.product.service;

import com.example.csmall.product.pojo.dto.AlbumAddNewDTO;


/**
 * 处理相册数据的业务接口
 */
public interface IAlbumService {

    void addNew(AlbumAddNewDTO albumAddNewDTO);

}
