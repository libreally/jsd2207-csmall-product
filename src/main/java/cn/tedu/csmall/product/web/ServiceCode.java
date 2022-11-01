package cn.tedu.csmall.product.web;

/**
 * 业务状态码
 *
 */
public enum ServiceCode {
    OK(20000),
    ERR_CONFLICT(40400),
    ERR_BAD_REQUEST(40000),
    ERR_NOT_FOUND(40900);



    private final Integer value;


    ServiceCode(Integer value){
        this.value=value;
    }
    public Integer getValue(){
        return value;
    }
}
