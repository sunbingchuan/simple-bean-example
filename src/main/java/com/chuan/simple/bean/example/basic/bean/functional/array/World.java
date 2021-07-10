package com.chuan.simple.bean.example.basic.bean.functional.array;

import com.chuan.simple.bean.annotation.Autowired;
import com.chuan.simple.bean.annotation.Component;
import com.chuan.simple.helper.common.ObjectHelper;

@Component
public class World {

    @Autowired
    private Economic[] economics;
    
    @Autowired
    private double[] gdp;
    
    @Autowired
    private Country[] countrys;
    
    public World() {
        
    }
    
    @Override
    public String toString() {
        return "\neconomics:"+ObjectHelper.toString(economics)
        +"\ngdp:"+doubleToString(gdp)
        +"\ncountrys:"+ObjectHelper.toString(countrys);
    }
    
    private String doubleToString(double[] ds) {
        StringBuffer sb = new  StringBuffer();
        for (int i = 0; i < ds.length; i++) {
            sb.append(ds[i]).append(",");
        }
        return sb.toString();
    }
    
}
