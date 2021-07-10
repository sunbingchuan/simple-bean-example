package com.chuan.simple.bean.example.basic.bean.functional.proxy;

import com.chuan.simple.bean.annotation.Component;

@Component
public class Demon {

    String helpless;
    String despair;
    String evil;
    
    
    public Demon() {
        System.out.println("恶魔无缘无故的产生了-----");
        System.out.println(this.getClass());
    }
    
    public Demon(String helpless,String despair,String evil) {
        this.helpless=helpless;
        this.despair=despair;
        this.evil=evil;
        System.out.println("恶魔由于"+helpless+"、"+despair+"、"+evil+"产生了");
    }
    
    @Override
    public String toString() {
        return "由 "+helpless+
                "和 "+despair+
                "和  " +evil + " 产生的邪恶";
    }
    
    public void doEvil(String evil) {
        System.out.println("恶魔开始作恶了:"+evil);
    }
    
}
