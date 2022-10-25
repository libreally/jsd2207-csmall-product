package com.example.csmall.product.pojo.vo;

import lombok.Data;
import java.io.Serializable;

@Data
public class AttributeTemplateListVO implements Serializable {
    private Long id;
    private String name;
    private String pinyin;
    private String keywords;
    private Integer sort;
}
