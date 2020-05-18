package com.wsd.powerful.admin.exception;

import com.wsd.powerful.common.api.CommonResult;
import com.wsd.powerful.common.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @description 全局异常处理
 * @author      tm
 * @createDate  2020-4-19 13:11
 * @updateDate  2020-4-19 13:11
 * @updateUser
 * @updateRemark
 * @version     1.0.0
*/
@Slf4j
@ControllerAdvice
public class ExceptionHandlerAdvice {

    /**
     *@description 参数校验异常处理
     *@params  [ex] 异常信息
     *@return  CommonResult
     *@author  tm
     *@createDate  2020-5-14 18:18
     *@updateRemark
     */
    @ExceptionHandler(value = {BusinessException.class})
    public CommonResult handle(BusinessException ex) {
        log.error("业务异常msg:{}",ex.getMessage());
        return CommonResult.failed(ex.getMessage());
    }

    /**
     *@description 所有异常处理
     *@params  [throwable]
     *@return  CommonResult
     *@author  tm
     *@createDate  2020-5-14 18:19
     *@updateRemark
     */
    @ExceptionHandler(value = {Throwable.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public CommonResult handle(Throwable throwable) {
        log.error("系统异常msg:{}",throwable.getMessage());
        if(throwable instanceof BusinessException) {
            return handle((BusinessException) throwable);
        }else {
            return CommonResult.failed(throwable.getMessage());
        }
    }
}
