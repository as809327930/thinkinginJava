package com.zhanglei.class14.class14_7;

import java.lang.reflect.*;

/**
 * @author zhanglei
 * @description 动态代理重写
 * @date 2018/12/27
 */
class DynamicProxyHandler implements InvocationHandler{
    private Object proxied;
    public DynamicProxyHandler(Object proxied){
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        System.out.println("**** proxy: " + proxy.getClass() +
                ", method: " + method + ", args: " + args);
        if(args != null){
            for(Object arg : args){
                System.out.println("  " + arg);
            }
        }
        return method.invoke(proxied,args);
    }
}
public class SimpleDynamicProxy {
    public static void consumer(Interface iface){
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);
        System.out.println("***************************");
        System.out.println("***************************");
        //insert a proxy and call again
        Interface proxy = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[]{Interface.class},
                new DynamicProxyHandler(real));
        System.out.println("***************************");
        System.out.println("***************************");
        consumer(proxy);
    }
}
