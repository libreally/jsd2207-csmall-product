package cn.tedu.csmall.product.web;

/**
 * 业务状态码
 *
 */
public enum ServiceCode {

    /**
     * 成功
     */
    OK(20000),
    ERR_BAD_REQUEST(40000),
    /**
     * 错误：数据不存在
     */
    ERR_NOT_FOUND(40400),
    /**
     * 错误：数据冲突
     */
    ERR_CONFLICT(40900),
    /**
     * 错误：插入数据错误
     */
    ERR_INSERT(50000),
    /**
     * 错误：删除数据错误
     */
    ERR_DELETE(50100),
    /**
     * 错误：修改数据错误
     */
    ERR_UPDATE(50200),
    /**
     * 错误：查询数据错误
     */
    ERR_SELECT(50300);
    private final Integer value;


    ServiceCode(Integer value){
        this.value=value;
    }
    public Integer getValue(){
        return value;
    }
}
