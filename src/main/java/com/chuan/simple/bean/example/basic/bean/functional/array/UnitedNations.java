package com.chuan.simple.bean.example.basic.bean.functional.array;

import com.chuan.simple.bean.annotation.Bean;
import com.chuan.simple.bean.annotation.Configuration;
import com.chuan.simple.bean.annotation.Order;

@Configuration
public class UnitedNations {

    @Bean
    @Order(1)
    private Country china() {
        return new Country("中国");
    }
    
    @Bean
    private Country america() {
        return new Country("美国");
    }
    
    @Bean
    private Country england() {
        return new Country("英国");
    }
    
    @Bean
    private Country italy() {
        return new Country("意大利");
    }
    
}

