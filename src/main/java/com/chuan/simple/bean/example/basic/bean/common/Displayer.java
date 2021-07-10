package com.chuan.simple.bean.example.basic.bean.common;

public class Displayer {

    String content;
    
    public Displayer(String content) {
        this.content=content;
    }
    
    @Override
    public String toString() {
       return "display:"+content;
    }
    
}
