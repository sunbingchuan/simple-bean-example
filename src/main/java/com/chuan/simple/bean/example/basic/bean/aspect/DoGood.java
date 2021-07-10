package com.chuan.simple.bean.example.basic.bean.aspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.chuan.simple.bean.annotation.Component;

@Component
public class DoGood implements InvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Do good!");
        return method.invoke(proxy, args);
    }

}
