package com.wsd.powerful.common.api;

/**
 * @description 封装API的错误码
 * @author      tm
 * @createDate  2020-5-14 11:29
 * @updateDate  2020-5-14 11:29
 * @updateUser
 * @updateRemark
 * @version     1.0.0
*/
public interface IErrorCode {
    long getCode();

    String getMessage();
}
