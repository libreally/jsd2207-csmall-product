package cn.tedu.csmall.product.web;

import cn.tedu.csmall.product.ex.ServiceException;
import lombok.Data;

import java.io.Serializable;
@Data
public class JsonResult implements Serializable {
    private Integer state;
    private String message;

    public static JsonResult ok(){
        JsonResult jsonResult = new JsonResult();
        jsonResult.state=ServiceCode.OK.getValue();
        return jsonResult;
    }
    public static JsonResult fail(ServiceException e){
        return fail(e.getServiceCode(), e.getMessage());

    }
    public static JsonResult fail(ServiceCode serviceCode,String message){
        JsonResult jsonResult = new JsonResult();
        jsonResult.state=serviceCode.getValue();
        jsonResult.message=message;
        return jsonResult;
    }

}
