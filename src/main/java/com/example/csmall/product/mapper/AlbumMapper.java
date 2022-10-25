package com.example.csmall.product.mapper;

import com.example.csmall.product.pojo.vo.AlbumListItemVO;
import com.example.csmall.product.pojo.vo.AlbumStandardVO;
import com.example.csmall.product.pojo.entity.Album;
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
     * @param album 封装对象
     * @return int
     */
    int insert(Album album);

    /**
     * 批量插入
     * @param albums 封装对象
     * @return int
     */
    int insertBatch(List<Album> albums);

    /**
     * 根据id删除
     * @param id 根据id删除
     * @return int
     */
    int deleteById(Long id);
    /**
     * 根据多个id删除
     * @param ids 根据多个id删除
     * @return int
     */
    int deleteByIds(Long[] ids);

    /**
     * 动态修改数据
     * @return int
     */
    int update(Album album);

    /**
     * 统计相册中数据数量
     * @return int 返回数量
     */
    int count();

    /**
     * 根据id查询相册数据的详情
     * @param id 根据id查询相册数据的详情
     * @return AlbumVO
     */
    AlbumStandardVO getStandardByID(Long id);

    /**
     * 查询相册列
     * @return List
     */
    List<AlbumListItemVO> list();

}
