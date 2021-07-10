package com.chuan.simple.bean.example.basic.bean.functional.proxy;

import java.lang.reflect.Method;

import com.chuan.simple.bean.annotation.Around;
import com.chuan.simple.bean.annotation.Aspect;

@Aspect
public class Salvation {
    

     @Around("* *..Demon.new(..)")
     public Object salvate(Object proxy, Method method, Object[] args)throws Throwable{
         System.out.println("真善美除恶之源");
         return method.invoke(proxy, args);
     }
    
     @Around("* *..Demon.doEvil(..)")
     public Object discipline(Object proxy, Method method, Object[] args)throws Throwable{
         System.out.println("所有真正的恶魔要受到惩戒");
         Object result = method.invoke(proxy, args);
         return result;
     }
     
}
