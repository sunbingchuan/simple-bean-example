package com.chuan.simple.bean.example.basic.bean.common;

public class Miracle {

    private String type;
    
    public Miracle(String type) {
        this.type=type;
    }
    
    @Override
    public String toString() {
        return "You create a "+type+" miracle!";
    }
    
}
