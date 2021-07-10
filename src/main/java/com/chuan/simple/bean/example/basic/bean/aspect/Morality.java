package com.chuan.simple.bean.example.basic.bean.aspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.chuan.simple.bean.annotation.Around;
import com.chuan.simple.bean.annotation.Aspect;

@Aspect
public class Morality {

    @Around("* *.live()")
    public Object kindness(Object proxy, Method method, Object[] args)throws Throwable{
        System.out.println("Be kindness!");
        return method.invoke(proxy, args);
    }
    @Around("* *.create()")
    public InvocationHandler honest(){
        return new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("Be honest!");
                return method.invoke(proxy, args);
            }
        };
    }
    @Around("* *.work()")
    public String doGood() {
        return "doGood";
    }
    
}
