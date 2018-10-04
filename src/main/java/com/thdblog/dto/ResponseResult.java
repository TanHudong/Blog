package com.thdblog.dto;

import lombok.Data;

import javax.xml.ws.Service;

/**
 * @author tanhudong
 * @mail 514390025@qq.com
 * @date 2018/10/4 23:36
 * @Description 响应结果
 */
@Data
public class ResponseResult<T> {
    private boolean successful;

    private String msg;

    private T object;

    public static <T> ResponseResult<T> from(ServiceResult serviceResult){
        ResponseResult<T> responseResult = new ResponseResult();
        responseResult.setSuccessful(serviceResult.isSuccessful());
        responseResult.setMsg(serviceResult.getMessage());
        return responseResult;
    }

    public static <T> ResponseResult<T> from(ServiceResult serviceResult, String objectName) {
        ResponseResult<T> result = new ResponseResult<>();
        result.setSuccessful(serviceResult.isSuccessful());
        result.setMsg(serviceResult.getMessage());
        if (serviceResult.isSuccessful()) {
            result.setObject((T) serviceResult.getExtra(objectName));
        }
        return result;
    }

    public static <T> ResponseResult<T> from(ServiceResult serviceResult, T object) {
        ResponseResult<T> result = new ResponseResult<>();
        result.setSuccessful(serviceResult.isSuccessful());
        result.setMsg(serviceResult.getMessage());
        result.setObject(object);
        return result;
    }
}
