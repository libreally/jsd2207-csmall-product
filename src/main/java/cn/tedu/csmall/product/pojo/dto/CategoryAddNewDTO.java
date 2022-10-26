package cn.tedu.csmall.product.pojo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryAddNewDTO implements Serializable {
    private String name;
    private Long parentId;
    private Integer depth;
    private Integer sort;
}
