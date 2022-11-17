package cn.tedu.csmall.product.service;

import cn.tedu.csmall.product.pojo.dto.SpuAddNewDTO;
import org.springframework.transaction.annotation.Transactional;

/**
 * spu接口业务
 */
@Transactional
public interface ISpuService {
    /**
     * 添加spu
     * @param spuAddNewDTO 添加spu的对象
     */
    void addNew(SpuAddNewDTO spuAddNewDTO);
}
