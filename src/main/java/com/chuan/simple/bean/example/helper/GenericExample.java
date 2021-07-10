package com.chuan.simple.bean.example.helper;

import org.junit.Test;

import com.chuan.simple.helper.generic.GenericType;
import com.chuan.simple.helper.generic.GenericTypeHelper;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class GenericExample {
    class A<X,Y>{

    }
    class B<X> extends A<X,Object>{

    }
    class C extends  B<String>{

    }
    class D{
        B<Long> b;
        D(B<Integer> b){
            System.out.println(b);
        }
        void d(B<Integer> b){
            System.out.println(b);
        }
    }


    @Test
    public void genericTypeUsage() throws Exception{
        //Class generic type
        System.out.println("--------------Class generic type------------");
        Set<GenericType> genericTypes = GenericTypeHelper.getGenericTypes(C.class);
        System.out.println(genericTypes);

        GenericType  genericType= GenericTypeHelper.getGenericType(genericTypes,A.class,1);
        System.out.println(genericType.getActualType());

        genericType =GenericTypeHelper.getGenericType(C.class,A.class,1);
        System.out.println(genericType.getActualType());


        List<Class<?>> classes =GenericTypeHelper.getGenericClasses(C.class,A.class);
        System.out.println(classes);

        Class<?> clazz =GenericTypeHelper.getGenericClass(C.class,A.class,1);
        System.out.println(clazz);
        //Field generic type
        System.out.println("--------------Field generic type------------");
        Field f = D.class.getDeclaredField("b");
        genericTypes = GenericTypeHelper.getGenericTypes(f);
        System.out.println(genericTypes);

        genericType= GenericTypeHelper.getGenericType(genericTypes,B.class,0);
        System.out.println(genericType.getActualType());

        genericType =GenericTypeHelper.getGenericType(f,B.class,0);
        System.out.println(genericType.getActualType());


        classes =GenericTypeHelper.getGenericClasses(f,B.class);
        System.out.println(classes);

        clazz =GenericTypeHelper.getGenericClass(f,B.class,0);
        System.out.println(clazz);

        //Parameter generic type
        System.out.println("---------------Parameter generic type--------------");
        Method m = D.class.getDeclaredMethod("d",B.class);
        Parameter p = m.getParameters()[0];
        genericTypes = GenericTypeHelper.getGenericTypes(p);
        System.out.println(genericTypes);

        genericType= GenericTypeHelper.getGenericType(genericTypes,B.class,0);
        System.out.println(genericType.getActualType());

        genericType =GenericTypeHelper.getGenericType(p,B.class,0);
        System.out.println(genericType.getActualType());


        classes =GenericTypeHelper.getGenericClasses(p,B.class);
        System.out.println(classes);

        clazz =GenericTypeHelper.getGenericClass(p,B.class,0);
        System.out.println(clazz);

    }
}
