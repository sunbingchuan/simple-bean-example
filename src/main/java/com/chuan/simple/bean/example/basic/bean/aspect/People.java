package com.chuan.simple.bean.example.basic.bean.aspect;

import com.chuan.simple.bean.annotation.Component;
import com.chuan.simple.bean.annotation.Scope;
import com.chuan.simple.bean.core.build.builder.Builder;

@Component
@Scope(Builder.SCOPE_PROTOTYPE)
public class People {
   
    public void live() {
        System.out.println("live");
    }
    
    public void work() {
        System.out.println("work"); 
    }
    
    public void create() {
        System.out.println("create"); 
    }
}
