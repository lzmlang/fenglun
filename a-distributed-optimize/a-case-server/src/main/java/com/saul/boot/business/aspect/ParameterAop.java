package com.saul.boot.business.aspect;

import com.saul.boot.business.model.TeamException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 功能描述: 相关接口参数校验aop
 *
 * @Param:
 * @Return:
 * @Author: luo_zm
 * @Date: 2020/7/6 15:41
 */
@Aspect
@Component
public class ParameterAop {
    @Autowired
    private HttpServletRequest request;

    @Before("@annotation(com.saul.boot.business.aspect.Parameter)")
    public Object interceptor(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        if (request == null) {
            throw new TeamException("缺失请求参数");
        }
        return args;
    }
}