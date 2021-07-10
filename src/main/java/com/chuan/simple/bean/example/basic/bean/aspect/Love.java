package com.chuan.simple.bean.example.basic.bean.aspect;

import java.lang.reflect.Method;

import com.chuan.simple.bean.annotation.Around;
import com.chuan.simple.bean.annotation.Aspect;

@Aspect
public class Love {

    @Around("* com.chuan.simple.bean.example.basic.bean.aspect.LonelyPerson.defeat(..)")
    public Object love(Object proxy, Method method, Object[] args)throws Throwable{
        System.out.println("By love");
        return method.invoke(proxy, args);
    }
    
}
