package com.example.csmall.product.mapper;

import com.example.csmall.product.pojo.entity.Album;
/*执行的sql语句是增 删 时使用int 作为返回值*/

/**
 * 处理相册问题
 * @author liberally
 *
 */
public interface AlbumMapper {
    /**
     * 插入相册数据
     * @param album
     * @return int
     */
    int insert(Album album);
}
