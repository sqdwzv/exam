package cn.wangzhen.Anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
    /*切点表达式抽取*/
    @Pointcut("execution(* cn.wangzhen.Anno.TargetInterFaceImpl.*(..))")
    public void myPointcut(){}
    @Around("myPointcut()")
    public void around(ProceedingJoinPoint pjp){

        try {
            System.out.println("前置增强通知");
            pjp.proceed();
            System.out.println("后置增强通知");
        } catch (Throwable throwable) {
            throwable.fillInStackTrace();
            System.out.println("异常增强通知");
        }finally {
            System.out.println("最终增强通知");
        }
    }

    /*@Before("execution(* cn.wangzhen.Anno.TargetInterFaceImpl.*(..))")
    public void before(){
        System.out.println("前置增强方法");
    }
    @AfterReturning("execution(* cn.wangzhen.Anno.TargetInterFaceImpl.*(..))")
    public void afterReturning(){
        System.out.println("后置通知");
    }
    @AfterThrowing("execution(* cn.wangzhen.Anno.TargetInterFaceImpl.*(..))")
    public void throwring(){
        System.out.println("异常通知");
    }
    @After("execution(* cn.wangzhen.Anno.TargetInterFaceImpl.*(..))")
    public void after(){
        System.out.println("最终通知");
    }
    @Around("execution(* cn.wangzhen.Anno.TargetInterFaceImpl.*(..))")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前置");
        pjp.proceed();
        System.out.println("环绕最终");
    }*/
}
