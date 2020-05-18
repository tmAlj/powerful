package com.wsd.powerful.common.exception;

/**
 * @description 异常类
 * @author      tm
 * @createDate  2020-5-14 11:32
 * @updateDate  2020-5-14 11:32
 * @updateUser
 * @updateRemark
 * @version     1.0.0
*/
public class BusinessException extends Exception {

    public BusinessException(){super();}

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
