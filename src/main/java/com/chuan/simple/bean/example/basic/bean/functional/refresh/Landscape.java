package com.chuan.simple.bean.example.basic.bean.functional.refresh;

import com.chuan.simple.bean.annotation.Bean;
import com.chuan.simple.bean.annotation.Configuration;

@Configuration
public class Landscape {

    @Bean
    public String mountainName() {
        return "泰山";
    }
    
}
