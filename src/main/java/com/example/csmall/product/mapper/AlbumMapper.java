package com.example.csmall.product.mapper;

import com.example.csmall.product.pojo.entity.Album;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/*执行的sql语句是增 删 时使用int 作为返回值*/

/**
 * 处理相册问题
 * @author liberally
 *
 */

@Repository
public interface AlbumMapper {
    /**
     * 插入相册数据
     * @param album
     * @return int
     */
    int insert(Album album);

    /**
     * 批量插入
     * @param albums
     * @return int
     */
    int insertBatch(List<Album> albums);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteById(Long id);
    /**
     * 根据多个id删除
     * @param ids
     * @return
     */
    int deleteByIds(Long[] ids);

}
