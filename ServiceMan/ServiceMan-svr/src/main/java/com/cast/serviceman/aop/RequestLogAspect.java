package com.cast.serviceman.aop;

import com.google.gson.Gson;
import org.apache.dubbo.common.utils.ArrayUtils;
import org.apache.dubbo.rpc.RpcContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Parameter;

/**
 * <p>Title:统一切面打印日志信息 </p>
 * <p>Description:</p>
 *
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history: Created by wanglei on  2020/6/17
 */
@Aspect
@Component
public class RequestLogAspect {
    private final static Logger logger = LoggerFactory.getLogger(RequestLogAspect.class);

    /** 以 controller 包下定义的所有请求为切入点 */
    @Pointcut("execution(public * com.cast.serviceman.server.service.*.*(..))")
    public void webLog() {}

    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String clientIP  = RpcContext.getContext().getRemoteHost();
        // 打印请求相关参数
        logger.info("================================= request Start ==========================================");
        // 所在的类.方法
        String msgInfo = "@AOP日志[clientIP : " +clientIP + " request Class path: "+ joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() + "]";
        String requestStr = getRequestParam(joinPoint);
        logger.info(msgInfo + "[输入参数]：" + requestStr);
        long startTime = System.currentTimeMillis();
        Object result = null;
        try {
            // 执行完方法的返回值：调用proceed()方法，就会触发切入点方法执行
            result = joinPoint.proceed();
        } catch (Exception e) {
            //如果有异常继续抛
            throw e;
        } finally {
            long handleTime = System.currentTimeMillis() - startTime;
            String responseStr = result == null ? "无" : new Gson().toJson(result);
            String endString = msgInfo + "end." +
                    "耗时(" + handleTime + "ms)" +
                    "输出参数：" + responseStr;
            logger.info(endString);
        }
        logger.info("=========================================== request  End ===========================================");
        // 每个请求之间空一行
        logger.info("");
        return result;
    }

    /**
     * 获取请求参数
     *
     * @param point
     * @return
     */
    private String getRequestParam(ProceedingJoinPoint point) {
        Object[] methodArgs = point.getArgs();
        Parameter[] parameters = ((MethodSignature) point.getSignature()).getMethod().getParameters();
        String requestStr;
        try {
            requestStr = logParam(parameters, methodArgs);
        } catch (Exception e) {
            requestStr = "获取参数失败";
        }
        return requestStr;
    }

    /**
     * 拼接请求参数
     *
     * @param paramsArgsName
     * @param paramsArgsValue
     * @return
     */
    private String logParam(Parameter[] paramsArgsName, Object[] paramsArgsValue) {
        if (ArrayUtils.isEmpty(paramsArgsName) || ArrayUtils.isEmpty(paramsArgsValue)) {
            return "";
        }
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < paramsArgsValue.length; i++) {
            //参数名
            String name = paramsArgsName[i].getName();
            //参数值
            Object value = paramsArgsValue[i];
            buffer.append(name + "=");
            if (value instanceof String) {
                buffer.append(value + ",");
            } else {
                buffer.append(new Gson().toJson(value) + ",");
            }
        }
        return buffer.toString();
    }
}
