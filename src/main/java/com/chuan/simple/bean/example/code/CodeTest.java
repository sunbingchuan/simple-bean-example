package com.chuan.simple.bean.example.code;

import org.junit.Test;

import com.chuan.simple.bean.core.SimpleContext;
import com.chuan.simple.bean.example.code.bean.Commerce;
import com.chuan.simple.bean.example.code.bean.WallStreet;

public class CodeTest {

    @Test
    public void configTest() throws Exception {
        SimpleContext context = new SimpleContext("code/code-test.sp");
        /**
         * Config test
         */
        System.out.println("--------------- Config test------------");
        Commerce commerce = (Commerce)context.build("commerce");
        System.out.println(commerce);
        WallStreet wallStreet = (WallStreet)context.build("wallStreet");
        System.out.println(wallStreet);
    }
    
}
