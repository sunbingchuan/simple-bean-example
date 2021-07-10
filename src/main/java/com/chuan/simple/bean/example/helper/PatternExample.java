package com.chuan.simple.bean.example.helper;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

import com.chuan.simple.helper.common.PatternHelper;

public class PatternExample {

    @Test
    public void matchStringsUsage() throws Exception {
        Map<String, String> map =new HashMap<String, String>();
        System.out.println(PatternHelper.matchStrings("*xfdas{number:\\d+}{fff}","*xfdas1234addd" , map));
        System.out.println(map);
        System.out.println(PatternHelper.matchStrings("*xfdas{number:\\d+}{fff}","*xfdas1234addd"));
        System.out.println(PatternHelper.matchStrings("fff*asdf?d","fffddddasdfrd"));
    }
    @Test
    public void matchPathUsage() throws Exception {
        System.out.println(PatternHelper.matchPath("/abc/**/*.class", "/abc/bcd/cwm/yy.class"));
    }
    @Test
    public void matchStartUsage() throws Exception {
        System.out.println(PatternHelper.matchStart("/abc/**/*.class", "/abc/bcd/cwm"));
    }
    @Test
    public void matchNameUsage() throws Exception {
        System.out.println(PatternHelper.matchName("abc.bcd..success", "abc.bcd.x.y.z.success"));
    }
    
}
