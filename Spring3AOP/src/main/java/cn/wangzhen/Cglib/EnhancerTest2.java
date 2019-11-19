package cn.wangzhen.Cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

public class EnhancerTest2 {
    public static void main(final String[] args) {
        //设置目标对象
        final Target target = new Target();
        //创建增强对象
        final Advice advice = new Advice();
        //创建增强器
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(Target.class);
        //设置回调
        enhancer.setCallback(new InvocationHandler() {
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                advice.before();
                Object invoke = method.invoke(target, args);
                advice.after();
                return null;
            }
        });
        Target proxy = (Target) enhancer.create();//创建代理对象
        proxy.method();
    }
}
