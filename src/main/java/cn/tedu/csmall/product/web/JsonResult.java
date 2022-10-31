package cn.tedu.csmall.product.web;

import lombok.Data;

import java.io.Serializable;
@Data
public class JsonResult implements Serializable {
    private Integer state;
    private String message;

    public JsonResult() {
    }

    public JsonResult(Integer state, String message) {
        this.state = state;
        this.message = message;
    }
    public static JsonResult ok( ){
        JsonResult jsonResult = new JsonResult();
        jsonResult.state=1;
        return jsonResult;
    }
    public static JsonResult fail(Integer state,String message){
        JsonResult jsonResult = new JsonResult();
        jsonResult.state=state;
        jsonResult.message=message;
        return jsonResult;
    }

}