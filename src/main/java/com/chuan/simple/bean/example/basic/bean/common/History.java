package com.chuan.simple.bean.example.basic.bean.common;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class History {

    private Map<String, String> dynastys;
    
    private String[] storys;
    
    private List<String> celebrity;
    
    @Override
    public String toString() {
        return "History is:\n"
                + "dynastys:"+dynastys+"\n"
                + "storys:"+Arrays.asList(storys)+"\n"
                + "celebrity:"+celebrity+"\n";
    }
    
}
