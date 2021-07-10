package com.chuan.simple.bean.example.basic.bean.functional.array;

import com.chuan.simple.bean.annotation.Autowired;

public class LivingCondition {

    private  String name;
    
    @Autowired
    public LivingCondition(String name) {
        this.name=name;
    }
    
    @Override
    public String toString() {
        return name;
    }
    
}
