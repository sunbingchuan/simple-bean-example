package com.chuan.simple.bean.example.basic.bean.functional.array;

import com.chuan.simple.bean.annotation.Autowired;
import com.chuan.simple.bean.annotation.Bean;
import com.chuan.simple.bean.annotation.Configuration;

@Configuration
public class Economic {
    String name="economic";
    
    @Autowired("communism")
    public Economic(String name) {
        this.name=name;
    }
    @Bean
    public Economic developing() {
        return new Economic("发展中");
    }
    @Bean
    public Economic developed() {
        return new Economic("发达");
    }
    @Bean
    public Economic poverty() {
        return new Economic("贫民窟");
    }
    @Override
    public String toString() {
       return "economic:"+this.name;
    }
}
