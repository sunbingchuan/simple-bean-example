package com.chuan.simple.bean.example.basic.bean.functional.array;

import com.chuan.simple.bean.annotation.Bean;
import com.chuan.simple.bean.annotation.Configuration;
import com.chuan.simple.bean.annotation.Order;

@Configuration
public class Guide {

    @Bean
    private String conditionName() {
        return "土壤";
    }
    
    @Bean
    private String communism() {
        return "共产主义";
    }
    
    @Bean
    private double small() {
        return 100000000;
    }
    
    @Bean
    private double middle() {
        return 10000e8;
    }
    
    @Bean
    @Order(1)
    private double big() {
        return 10000e12;
    }
}
