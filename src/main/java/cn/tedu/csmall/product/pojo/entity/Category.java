package cn.tedu.csmall.product.pojo.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Category implements Serializable {
    private Long id;
    private String name;
    private Long parentId;
    private Integer depth;
    private String keywords;
    private Integer sort;
    private String icon;
    private Integer enable;
    private Integer isParent;
    private Integer isDisplay;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;

    public Category() {
    }

    public Category(String name, Long parentId, Integer depth, String keywords, Integer sort, String icon, Integer enable, Integer isParent, Integer isDisplay, LocalDateTime gmtCreate, LocalDateTime gmtModified) {
        this.name = name;
        this.parentId = parentId;
        this.depth = depth;
        this.keywords = keywords;
        this.sort = sort;
        this.icon = icon;
        this.enable = enable;
        this.isParent = isParent;
        this.isDisplay = isDisplay;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }
}
