package cn.wangzhen.Cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

public class EnhancerTest3 {
    public static void main(final String[] args) {
        //创建目标对象 连接点所属对象
        final Target target = new Target();
        //创建增强对象  切面类,通知
        final Advice advice = new Advice();
        //创建增强器
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(Target.class);
        //设置回调
        enhancer.setCallback(new InvocationHandler() {
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                advice.after();
                method.invoke(target,args);
                advice.before();
                //未写完
                return null;
            }
        });
        Target proxy  = (Target) enhancer.create();//创建代理对象

        proxy.method();
    }
}
