package com.chuan.simple.bean.example.basic.bean.functional.scope;

import java.util.Random;

import com.chuan.simple.bean.annotation.Scope;
import com.chuan.simple.bean.annotation.Service;
import com.chuan.simple.bean.core.build.builder.Builder;

@Service
@Scope(Builder.SCOPE_PROTOTYPE)
public class Happy {

    
    private int id;
    
    public Happy() {
        this.id = new Random().nextInt();
    }
    
    
    @Override
    public String toString() {
        return "Your happy id is "+id;
    }
    
}
