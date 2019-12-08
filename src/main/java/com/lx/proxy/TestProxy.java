package com.lx.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TestProxy implements InvocationHandler {
    private Object target;

    public TestProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        long start = System.currentTimeMillis();
        Object res = method.invoke(target, objects);
        long end = System.currentTimeMillis();
        System.out.println(end-start+"");
        return null;
    }
}
