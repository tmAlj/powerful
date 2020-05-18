package com.wsd.powerful.admin.interceptor;

import com.wsd.powerful.common.api.CommonResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * @description HibernateValidator错误结果处理切面
 * @author      tm
 * @createDate  2020-5-14 19:58
 * @updateDate  2020-5-14 19:58
 * @updateUser
 * @updateRemark
 * @version     1.0.0
*/
@Aspect
@Component
public class BindingResultAspect {

    @Pointcut("execution(* com.wsd.powerful.admin.controller..*.*(..))")
    public void BindingResult() {
    }

    @Around("BindingResult()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof BindingResult) {
                BindingResult result = (BindingResult) arg;
                if (result.hasErrors()) {
                    FieldError fieldError = result.getFieldError();
                    if(fieldError!=null){
                        return CommonResult.validateFailed(fieldError.getDefaultMessage());
                    }else{
                        return CommonResult.validateFailed();
                    }
                }
            }
        }
        return joinPoint.proceed();
    }
}
