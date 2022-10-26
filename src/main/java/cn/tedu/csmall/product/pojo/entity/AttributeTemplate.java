package cn.tedu.csmall.product.pojo.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class AttributeTemplate implements Serializable {
    private Long id;
    private String name;
    private String pinyin;
    private String keywords;
    private Integer sort;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;

    public AttributeTemplate() {
    }

    public AttributeTemplate( String name, String pinyin, String keywords, Integer sort, LocalDateTime gmtCreate, LocalDateTime gmtModified) {
        this.name = name;
        this.pinyin = pinyin;
        this.keywords = keywords;
        this.sort = sort;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }
}
