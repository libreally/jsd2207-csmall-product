package cn.tedu.csmall.product.pojo.vo;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class AttributeStanderVO {
    /**
     * 记录id
     */
    private Long id;

    /**
     * 所属属性模板id
     */
    private Long templateId;

    /**
     * 属性名称
     */
    private String name;

    /**
     * 简介（某些属性名称可能相同，通过简介补充描述）
     */
    private String description;

    /**
     * 自定义排序序号
     */
    private Integer sort;

}
