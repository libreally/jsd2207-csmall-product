package cn.tedu.csmall.product.pojo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BrandAddNewDTO implements Serializable {
    private String name;
    private String pinyin;
    private Integer sort;
}
