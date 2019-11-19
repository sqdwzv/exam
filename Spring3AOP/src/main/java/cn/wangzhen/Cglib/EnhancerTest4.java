package cn.wangzhen.Cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;
//Cglib动态代理
public class EnhancerTest4 {
    public static void main(final String[] args) {
        final Target target = new Target();//创建目标对象 含有 连接点  切点
        final Advice advice = new Advice();//创建增强对象 含有 通知 增强
        Enhancer enhancer = new Enhancer();//创建增强器
        enhancer.setSuperclass(target.getClass());//设置父类
        //设置回调
        enhancer.setCallback(new InvocationHandler() {
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                Target invoke =null;
                if (method.getName().equals("method")){
                    advice.before();
                   invoke = (Target) method.invoke(target, args);
                    advice.after();
                }
                return invoke;
            }
        });
        Target proxy = (Target) enhancer.create();//创建代理对象
        proxy.method(); //代理对象调用目标对象方法
    }
}
