package cn.wangzhen.jdk;

import cn.wangzhen.jdk.impl.TargetInterFaceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//JDK动态代理
public class ProxyPlant {
    public static void main(String[] args) {
        final TargetInterFaceImpl targetInterFace = new TargetInterFaceImpl();//目标对象
        final Advice advice = new Advice();//创建增强对象
        //创建代理对象
        TargetInterFace proxy = (TargetInterFace) Proxy.newProxyInstance(targetInterFace.getClass().getClassLoader(), targetInterFace.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                advice.before();
                Object invoke = method.invoke(targetInterFace, args);
                advice.after();
                return invoke;
            }
        });
        proxy.method();
    }
}
