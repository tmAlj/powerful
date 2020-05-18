package com.wsd.powerful.common.api;

/**
 * @description 通用返回对象
 * @author      tm
 * @createDate  2020-5-14 11:24
 * @updateDate  2020-5-14 11:24
 * @updateUser
 * @updateRemark
 * @version     1.0.0
*/
public class CommonResult<T> {
    private long code;
    private String message;
    private T data;

    protected CommonResult() {
    }

    protected CommonResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     *@description 成功返回结果
     *@params  [data]
     *@return  com.wsd.powerful.common.api.CommonResult<T>
     *@author  tm
     *@createDate  2020-5-14 11:24
     *@updateRemark
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     *@description 成功返回结果
     *@params  [data, message]
     *@return  com.wsd.powerful.common.api.CommonResult<T>
     *@author  tm
     *@createDate  2020-5-14 11:25
     *@updateRemark
     */
    public static <T> CommonResult<T> success(T data, String message) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     *@description 失败返回结果
     *@params  [errorCode]
     *@return  com.wsd.powerful.common.api.CommonResult<T>
     *@author  tm
     *@createDate  2020-5-14 11:26
     *@updateRemark
     */
    public static <T> CommonResult<T> failed(IErrorCode errorCode) {
        return new CommonResult<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     *@description 失败返回结果
     *@params  [message]
     *@return  com.wsd.powerful.common.api.CommonResult<T>
     *@author  tm
     *@createDate  2020-5-14 11:26
     *@updateRemark
     */
    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<T>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     *@description 失败返回结果
     *@params  []
     *@return  com.wsd.powerful.common.api.CommonResult<T>
     *@author  tm
     *@createDate  2020-5-14 11:26
     *@updateRemark
     */
    public static <T> CommonResult<T> failed() {
        return failed(ResultCode.FAILED);
    }

    /**
     *@description 参数验证失败返回结果
     *@params  []
     *@return  com.wsd.powerful.common.api.CommonResult<T>
     *@author  tm
     *@createDate  2020-5-14 11:27
     *@updateRemark
     */
    public static <T> CommonResult<T> validateFailed() {
        return failed(ResultCode.VALIDATE_FAILED);
    }

    /**
     *@description 参数验证失败返回结果
     *@params  [message]
     *@return  com.wsd.powerful.common.api.CommonResult<T>
     *@author  tm
     *@createDate  2020-5-14 11:28
     *@updateRemark
     */
    public static <T> CommonResult<T> validateFailed(String message) {
        return new CommonResult<T>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     *@description 未登录返回结果
     *@params  [data]
     *@return  com.wsd.powerful.common.api.CommonResult<T>
     *@author  tm
     *@createDate  2020-5-14 11:28
     *@updateRemark
     */
    public static <T> CommonResult<T> unauthorized(T data) {
        return new CommonResult<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     *@description 未授权返回结果
     *@params  [data]
     *@return  com.wsd.powerful.common.api.CommonResult<T>
     *@author  tm
     *@createDate  2020-5-14 11:28
     *@updateRemark
     */
    public static <T> CommonResult<T> forbidden(T data) {
        return new CommonResult<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }

    /**
     *@description 请求异常返回结果
     *@params  [errorCode]
     *@return  com.wsd.powerful.common.api.CommonResult<T>
     *@author  tm
     *@createDate  2020-5-14 11:28
     *@updateRemark
     */
    public static <T> CommonResult<T> badResponse(IErrorCode errorCode) {
        return new CommonResult<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
