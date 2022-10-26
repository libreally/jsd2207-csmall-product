package cn.tedu.csmall.product.pojo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 添加相册的dto类
 */
@Data
public class AlbumAddNewDTO implements Serializable {
    private String name;
    private String description;
    private Integer sort;
}
