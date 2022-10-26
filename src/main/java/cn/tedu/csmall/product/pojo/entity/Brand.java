package cn.tedu.csmall.product.pojo.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Brand implements Serializable {
    private Long id;
    private String name;
    private String pinyin;
    private String logo;
    private String description;
    private String keywords;
    private Integer sort;
    private Integer sales;
    private Integer productCount;
    private Integer commentCount;
    private Integer positiveCommentCount;
    private Integer enable;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;

    public Brand() {
    }

    public Brand(String name, String pinyin, String logo, String description,
                 String keywords, Integer sort, Integer sales, Integer productCount,
                 Integer commentCount, Integer positiveCommentCount, Integer enable,
                 LocalDateTime gmtCreate, LocalDateTime gmtModified) {
        this.name = name;
        this.pinyin = pinyin;
        this.logo = logo;
        this.description = description;
        this.keywords = keywords;
        this.sort = sort;
        this.sales = sales;
        this.productCount = productCount;
        this.commentCount = commentCount;
        this.positiveCommentCount = positiveCommentCount;
        this.enable = enable;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }
}
