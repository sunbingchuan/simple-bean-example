package com.chuan.simple.bean.example.basic;

import java.util.Map.Entry;
import org.junit.Test;

import com.chuan.simple.bean.core.SimpleContext;
import com.chuan.simple.bean.core.build.builder.Builder;
import com.chuan.simple.bean.core.element.entity.BuildParameterElement;
import com.chuan.simple.bean.example.basic.bean.functional.array.SecondWorld;
import com.chuan.simple.bean.example.basic.bean.functional.array.World;
import com.chuan.simple.bean.example.basic.bean.functional.injection.Entity;
import com.chuan.simple.bean.example.basic.bean.functional.proxy.Demon;
import com.chuan.simple.bean.example.basic.bean.functional.refresh.Mountain;
import com.chuan.simple.bean.example.basic.bean.functional.scope.Happy;
import com.chuan.simple.bean.example.basic.bean.functional.scope.Thinker;
import com.chuan.simple.helper.method.MethodHelper;

public class FunctionalExample {

    @Test
    public void scopeUsage() throws Exception {
        SimpleContext context = new SimpleContext("basic/functional.sp");
        /**
         * Get bean by class
         */
        System.out.println("------Get bean by class-------");
        Happy happy = (Happy)context.build("happy");
        System.out.println(happy);
        happy = (Happy)context.build("happy");
        System.out.println(happy);
        Thinker thinker = (Thinker)context.build("thinker");
        thinker.getHappy(null);
        System.out.println(thinker.getHappy());
     }
    
    @Test
    public void arrayUsage() throws Exception {
        SimpleContext context = new SimpleContext("basic/functional.sp");
        /**
         * Autowired array
         */
        System.out.println("------Autowired array-------");
        World world = (World)context.build("world");
        System.out.println(world);
        SecondWorld secondWorld = (SecondWorld)context.build("secondWorld");
        System.out.println(secondWorld);
        
     }
    
    @Test
    public void injectionUsage() throws Exception {
        SimpleContext context = new SimpleContext("basic/functional.sp");
        /**
         * Parameter injection
         */
        System.out.println("------Parameter injection-------");
        Entity entityA = (Entity)context.build("entityA");
        System.out.println(entityA);
        Entity entityB = (Entity)context.build("entityB");
        System.out.println(entityB);
        Entity entityC = (Entity)context.build("entityC");
        System.out.println(entityC);
        Entity entityD = (Entity)context.build("entityD");
        System.out.println(entityD);
        Entity entityE = (Entity)context.build("entityE");
        System.out.println(entityE);
        for (Entry<String, Object> entry : entityE.getMapType().entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        } 
    }
    
    @Test
    public void proxyConstructor() throws Exception {
        SimpleContext context = new SimpleContext("basic/functional.sp");
        /**
         * Constructor proxy
         */
        System.out.println("---------------Constructor proxy------------");
        System.out.println("---------------Without parameter------------");
        Object demon = context.build("demon");
        System.out.println(demon instanceof Demon);
        MethodHelper.invoke(demon,"doEvil","欺骗");
        System.out.println(demon);
        System.out.println("---------------With parameter------------");
        Object initialDemon = context.build("initialDemon");
        System.out.println(initialDemon instanceof Demon);
        MethodHelper.invoke(initialDemon,"doEvil","作恶");
        System.out.println(initialDemon);
    }
    
    @Test
    public void refreshExample() throws Exception {
        SimpleContext context = new SimpleContext("basic/functional.sp");
        /**
         * Context refresh
         */
        System.out.println("---------------Context refresh------------");
        Mountain mountain = (Mountain) context.build("mountain");
        System.out.println(mountain);
        context.refresh();
        Mountain newMountain = (Mountain) context.build("mountain");
        System.out.println(newMountain);
        /**
         * Builder refresh
         */
        System.out.println("---------------Builder refresh------------");
        Builder<?> builder = context.getBuilder("mountain");
        mountain = (Mountain) builder.build();
        System.out.println(mountain);
        builder.refresh();
        mountain = (Mountain) builder.build();
        System.out.println(mountain);
        builder.refresh();
        BuildParameterElement buildParameterElement = new BuildParameterElement(Mountain.class.getName()); 
        buildParameterElement.setValue("苍山饶过谁");
        builder.clearElements(BuildParameterElement.class);
        builder.addElement(buildParameterElement);
        newMountain = (Mountain) builder.build();
        System.out.println(newMountain);
    }
    
}
