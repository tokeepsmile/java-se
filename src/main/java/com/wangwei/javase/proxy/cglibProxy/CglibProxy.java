package com.wangwei.javase.proxy.cglibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Method;

/**
 * @Auther wangwei
 * @Date 2018/5/5 下午3:33
 */
public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class c) {
        //设置创建子类的类
        enhancer.setSuperclass(c);
        enhancer.setCallback(NoOp.INSTANCE);
        return enhancer.create();
    }

    /**
     * 拦截所有目标类方法的调用
     *
     * @param o           目标类的实例
     * @param method      目标方法的反射对象
     * @param objects     方法参数
     * @param methodProxy 代理类的实例
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        /**
         * 代理类调用父类的方法
         */
        System.out.println("调用父类方法开始");
        methodProxy.invoke(o, objects);
        System.out.println("调用父类方法结束");
        return null;
    }
}
