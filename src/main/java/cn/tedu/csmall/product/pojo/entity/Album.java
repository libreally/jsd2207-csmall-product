package cn.tedu.csmall.product.pojo.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
/*利用@Data 和 lombok 依赖 并实现接口Serializable
* 简化 pojo的书写*/

@Data
public class Album  implements Serializable {
    private Long id;
    private String name;
    private String description;
    private Integer sort;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
}
