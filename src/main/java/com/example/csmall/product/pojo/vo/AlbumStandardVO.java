package com.example.csmall.product.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 相册的标准VO类
 */
@Data
public class AlbumStandardVO implements Serializable {
    private Long id;
    private String name;
    private String description ;
    private Integer sort;
}
