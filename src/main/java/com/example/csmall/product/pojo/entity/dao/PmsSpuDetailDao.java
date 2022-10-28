package com.example.csmall.product.pojo.entity.dao;

import com.example.csmall.product.pojo.entity.entity.PmsSpuDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * SPU详情(PmsSpuDetail)表数据库访问层
 *
 * @author makejava
 * @since 2022-10-28 19:25:57
 */
public interface PmsSpuDetailDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PmsSpuDetail queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param pmsSpuDetail 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<PmsSpuDetail> queryAllByLimit(PmsSpuDetail pmsSpuDetail, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param pmsSpuDetail 查询条件
     * @return 总行数
     */
    long count(PmsSpuDetail pmsSpuDetail);

    /**
     * 新增数据
     *
     * @param pmsSpuDetail 实例对象
     * @return 影响行数
     */
    int insert(PmsSpuDetail pmsSpuDetail);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PmsSpuDetail> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PmsSpuDetail> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PmsSpuDetail> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<PmsSpuDetail> entities);

    /**
     * 修改数据
     *
     * @param pmsSpuDetail 实例对象
     * @return 影响行数
     */
    int update(PmsSpuDetail pmsSpuDetail);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

