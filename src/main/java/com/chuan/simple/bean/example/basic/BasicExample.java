package com.chuan.simple.bean.example.basic;

import org.junit.Test;

import com.chuan.simple.bean.core.SimpleContext;
import com.chuan.simple.bean.example.basic.bean.aspect.LonelyPerson;
import com.chuan.simple.bean.example.basic.bean.aspect.People;
import com.chuan.simple.bean.example.basic.bean.common.Displayer;
import com.chuan.simple.bean.example.basic.bean.common.Experience;
import com.chuan.simple.bean.example.basic.bean.common.History;
import com.chuan.simple.bean.example.basic.bean.common.Life;
import com.chuan.simple.bean.example.basic.bean.common.Miracle;
import com.chuan.simple.bean.example.basic.bean.common.Success;
import com.chuan.simple.bean.example.basic.bean.scan.Breeze;
import com.chuan.simple.bean.example.basic.bean.scan.Drizzle;

public class BasicExample {

    
    public BasicExample() {
    }
    
    @Test
    public void commonUsage() throws Exception {
        SimpleContext context = new SimpleContext("basic/common.sp");
        /**
         * Get bean by class
         */
        System.out.println("------Get bean by class-------");
        Life life = context.build(Life.class);
        System.out.println(life);
        /**
         * Get bean by name
         */
        System.out.println("-------Get bean by name------");
        Experience experience = (Experience)context.build("experience");
        System.out.println(experience);
        /**
         * Get bean with constructor-arg
         */
        System.out.println("------Get bean with build-parameter-------");
        Success mySuccess = (Success)context.build("mySuccess");
        System.out.println(mySuccess);
        /**
         * get bean with field
         */
        System.out.println("------get bean with field-------");
        Success yourSuccess = (Success)context.build("yourSuccess");
        System.out.println(yourSuccess);
        /**
         * Configure multiple type
         */
        System.out.println("------Configure multiple type-------");
        History history = (History)context.build("history");
        System.out.println(history);
        /**
         * Import resource from sp file.
         */
        System.out.println("------Import resource from sp file.-------");
        Displayer fromImport = (Displayer) context.build("fromImport");
        System.out.println(fromImport);
        /**
         * Use order to set priority.
         */
        System.out.println("------Use order to set priority.-------");
        Displayer order = (Displayer) context.build(Displayer.class);
        System.out.println(order);
        /**
         * Alias usage.
         */
        System.out.println("------Alias usage.-------");
        Displayer aliasTest = (Displayer) context.build("aliasTest");
        System.out.println(aliasTest);
        Displayer alias1 = (Displayer) context.build("alias1");
        System.out.println(aliasTest.equals(alias1));
        Displayer alias4 = (Displayer) context.build("alias4");
        System.out.println(aliasTest.equals(alias4));
        Displayer alias7 = (Displayer) context.build("alias7");
        System.out.println(aliasTest.equals(alias7));
        /**
         * Builder bean by method(not constructor).
         */
        System.out.println("------Builder bean by method.-------");
        Miracle literaryMiracle = (Miracle) context.build("literaryMiracle");
        System.out.println(literaryMiracle);
        Miracle scientificMiracle = (Miracle) context.build("scientificMiracle");
        System.out.println(scientificMiracle);
    }
    
    @Test
    public void annotationUsage() throws Exception {
        SimpleContext context = new SimpleContext("basic/annotation.sp");
        /**
         * Bean with auto-generate name.
         */
        System.out.println("------Bean with auto-generate name.-------");
        Drizzle drizzle =  (Drizzle) context.build("drizzle");
        System.out.println(drizzle);
        /**
         * Bean with specified name.
         */
        System.out.println("------Bean with specified name.-------");
        Breeze springBreeze =  (Breeze) context.build("springBreeze");
        System.out.println(springBreeze);
        
    }
    
    @Test
    public void aspectUsage() throws Exception {
        SimpleContext context = new SimpleContext("basic/aspect.sp");
        /**
         * Create aspect.
         */
        System.out.println("------Create aspect.-------");
        People people = (People) context.build("people");
        /**
         * Aspect by method.
         */
        System.out.println("------Aspect by method.-------");
        people.live();
        /**
         * Aspect by handler.
         */
        System.out.println("------Aspect by handler.-------");
        people.create();
        /**
         * Aspect by bean.
         */
        System.out.println("------Aspect by bean.-------");
        people.work();
        /**
         * Method parameters injection.
         * @see Love
         */
        System.out.println("------Method parameters injection.-------");
        LonelyPerson lonelyPerson = (LonelyPerson) context.build("lonelyPerson");
        lonelyPerson.defeat(null);
        lonelyPerson.defeat(null,null);
        lonelyPerson.defeat("self",null);
        lonelyPerson.defeat(null,null,null);
        lonelyPerson.defeat(null,"self",null);

    }
    
    
}
