package com.chuan.simple.bean.example.basic.bean.functional.array;

import com.chuan.simple.bean.annotation.Autowired;
import com.chuan.simple.bean.annotation.Bean;
import com.chuan.simple.bean.annotation.Configuration;

@Configuration
public class Earth {

    @Bean
    public LivingCondition air() {
        return new LivingCondition("空气");
    }
    
    @Bean
    public LivingCondition water() {
        return new LivingCondition("水");
    }
    
    @Bean
    public LivingCondition other(@Autowired(name="conditionName") String conditionName) {
        return new LivingCondition(conditionName);
    }
    
}
