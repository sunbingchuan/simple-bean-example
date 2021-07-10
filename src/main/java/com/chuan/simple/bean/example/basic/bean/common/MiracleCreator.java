package com.chuan.simple.bean.example.basic.bean.common;


public class MiracleCreator {

    public Miracle create(String type) {
        return new Miracle(type);
    }
    
}
