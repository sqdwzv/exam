package cn.wangzhen.AOP;

import org.aspectj.lang.ProceedingJoinPoint;

//切面类
public class MyAspect {
    //前置方法
    public void before() {
        System.out.println("前置增强方法...");
    }
    //后置方法
    public void afterReturning (){
        System.out.println("后置增强方法...");
    }
    //异常方法
    public void throwing(){
        System.out.println("异常方法....");
    }
    //最终方法
    public void after(){
        System.out.println("最终方法");
    }
    //环绕方法
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("前置环绕方法");
        pjp.proceed();
        System.out.println("后置环绕方法");
    }
}
