package cn.tedu.csmall.product.pojo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AttributeTemplateDTO implements Serializable {
    private String name;
    private String pinyin;
    private String keywords;
    private Integer sort;
}
