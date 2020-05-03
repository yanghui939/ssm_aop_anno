package com.yh.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 使用注解aop有一个问题，就是执行顺序后置通知和最终通知调换了，使用需要注意，一般都使用环绕通知更稳定
 */
@Component
@Aspect
public class Log {

    @Pointcut("execution(* *..*.*ServiceImpl.*(..))")
    private void pt1(){}
    @Before("pt1()")
    public void before(){
        System.out.println("before");
    }
    @AfterReturning("pt1()")
    public void afterReturning(){
        System.out.println("afterReturning");
    }
    @AfterThrowing("pt1()")
    public void afterThrowing(){
        System.out.println("afterThrowing");
    }
    @After("pt1()")
    public void after(){
        System.out.println("after");
    }
//    @Around("pt1()")
    public Object around(ProceedingJoinPoint joinPoint){
        Object rtValue = null;
        try {
            Object[] args = joinPoint.getArgs();
            System.out.println("before");
            rtValue = joinPoint.proceed(args);
            System.out.println("afterReturning");
            return rtValue;
        } catch (Throwable e) {
            System.out.println("afterThrowing");
            throw new RuntimeException(e);
        }finally {
            System.out.println("after");
        }
    }
}
