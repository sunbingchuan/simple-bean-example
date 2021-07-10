package com.chuan.simple.bean.example.basic.bean.functional.scope;

import java.lang.reflect.Method;

import com.chuan.simple.bean.annotation.Around;
import com.chuan.simple.bean.annotation.Aspect;

@Aspect
public class Wisdom {

    @Around("* *..Thinker.*(..)")
    public Object  happyWisdom(Object proxy, Method method, Object[] args)throws Throwable {
        return method.invoke(proxy, args);
    }
    
    
}
