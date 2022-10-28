package cn.tedu.csmall.product.pojo.vo;

import lombok.Data;

@Data
public class BrandCategoryStanderVO {
    /**
     * 记录id
     */
    private Long id;

    /**
     * 品牌id
     */
    private Long brandId;

    /**
     * 类别id
     */
    private Long categoryId;
}
