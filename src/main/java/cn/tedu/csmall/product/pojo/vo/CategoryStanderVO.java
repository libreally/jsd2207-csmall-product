package cn.tedu.csmall.product.pojo.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryStanderVO implements Serializable {
    private Long id;
    private String  name;
    private Long    parentId;
    private Integer depth;
    private Integer sort;
}
