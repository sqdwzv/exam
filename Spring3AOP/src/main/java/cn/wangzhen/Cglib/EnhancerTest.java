package cn.wangzhen.Cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class EnhancerTest {
    public static void main(final String[] args) {
        final Target target = new Target(); //创建目标对象
        final Advice advice = new Advice();//增强对象
        Enhancer enhancer = new Enhancer();//创建增强器
        //设置父类
        enhancer.setSuperclass(Target.class);
     enhancer.setCallback(new MethodInterceptor() { //设置回调
         public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
             advice.after();
             Object invoke = method.invoke(target, args);
             advice.before();
             return invoke;
         }
     });
     //创建代理对象
        Target proxy = (Target) enhancer.create();
        proxy.method();
}

}
