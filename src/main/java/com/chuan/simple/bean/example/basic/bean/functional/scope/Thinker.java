package com.chuan.simple.bean.example.basic.bean.functional.scope;

import com.chuan.simple.bean.annotation.Autowired;
import com.chuan.simple.bean.annotation.Service;

@Service
public class Thinker {
    @Autowired
    private Happy happy;
    
    public Thinker() {
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
    
    @Autowired
    public void getHappy(Happy happy) {
        System.out.println("The thinker get happy: "+happy);
    }
    
    public Happy getHappy() {
        return happy;
    }
    
    
}
