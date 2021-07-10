package com.chuan.simple.bean.example.basic.bean.functional.refresh;

import com.chuan.simple.bean.annotation.Autowired;
import com.chuan.simple.bean.annotation.Component;
import com.chuan.simple.bean.core.build.builder.Manager;

@Component
public class Mountain  implements Manager{

    private String name;
    
    @Autowired
    public Mountain(String mountainName) {
        this.name=mountainName;
    }
    
    @Override
    public String toString() {
       return name+":"+super.toString();
    }
    
    @Override
    public void refresh() {
        System.out.println("Mountain refresh");
    }
    
}
