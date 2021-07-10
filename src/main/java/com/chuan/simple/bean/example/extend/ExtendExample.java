package com.chuan.simple.bean.example.extend;

import org.junit.Test;

import com.chuan.simple.bean.core.SimpleContext;
import com.chuan.simple.bean.example.extend.bean.LifeIdeal;
import com.chuan.simple.bean.example.extend.bean.ProfessionIdeal;
import com.chuan.simple.bean.example.extend.bean.SocietyIdeal;

public class ExtendExample {

    @Test
    public void commonExtendUsage() throws Exception {
        SimpleContext context = new SimpleContext("extend/common-extend.sp");
        /**
         * Common handler and proecssor extend example.
         */
        System.out.println("------------Common handler and proecssor extend example.-----------");
        LifeIdeal lifeIdeal = (LifeIdeal) context.build("lifeIdeal");
        System.out.println(lifeIdeal);
        ProfessionIdeal professionIdeal = (ProfessionIdeal) context.build("professionIdeal");
        System.out.println(professionIdeal);
        SocietyIdeal societyIdeal = (SocietyIdeal) context.build("societyIdeal");
        System.out.println(societyIdeal);
    }
    
}
