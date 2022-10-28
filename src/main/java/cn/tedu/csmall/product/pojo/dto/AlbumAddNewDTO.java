package cn.tedu.csmall.product.pojo.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 添加相册的dto类
 */
@Data
public class AlbumAddNewDTO implements Serializable {
    @ApiModelProperty("相册名称")
    private String name;
    @ApiModelProperty("相册简介")
    private String description;
    @ApiModelProperty("排序序号")
    private Integer sort;
}
