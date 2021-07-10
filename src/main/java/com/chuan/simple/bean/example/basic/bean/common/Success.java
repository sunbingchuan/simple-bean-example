package com.chuan.simple.bean.example.basic.bean.common;

public class Success {

    
    String conditionX;
    
    String conditionY;
    
    public Success() {
    }
    
    public Success(String conditionX,String conditionY) {
        this.conditionX=conditionX;
        this.conditionY=conditionY;
    }
    
    @Override
    public String toString() {
        return "Success = " + this.conditionX+"+"+this.conditionY;
    }
    
}
