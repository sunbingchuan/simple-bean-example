package com.chuan.simple.bean.example.helper;

import org.junit.Test;

import com.chuan.simple.annotation.SameAs;
import com.chuan.simple.helper.annotation.AnnotationAttribute;
import com.chuan.simple.helper.annotation.AnnotationAttributeHelper;
import com.chuan.simple.helper.annotation.AnnotationHelper;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class AnnotationExample {
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.TYPE})
    @interface  XX{

        String xx() default "x";

    }
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.METHOD})
    @interface  YY{
        String yy() default "y";
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.METHOD})
    @interface  ZZ{
        @SameAs(value = "xx",annotation = XX.class)
        String zz() default "zz";
    }

    @XX
    class A{
        @YY(yy="yyyy")
        void ab(){

        }
    }
    class B extends A{
        void ab(){

        }
    }
    class C{
        @ZZ(zz="zzzz")
        void c(){

        }
    }

    @Test
    public void annotationUsage() throws Exception{
        XX xx =AnnotationHelper.findAnnotation(A.class,XX.class);
        System.out.println(xx);

        xx =AnnotationHelper.findAnnotation(B.class,XX.class);
        System.out.println(xx);

        Method ma =A.class.getDeclaredMethod("ab");
        YY yy =AnnotationHelper.findAnnotation(ma,YY.class);
        System.out.println(yy);

        Method mb =B.class.getDeclaredMethod("ab");
        yy =AnnotationHelper.findAnnotation(mb,YY.class);
        System.out.println(yy);

        Annotation[] annotations = AnnotationHelper.getDeclaredAnnotations(A.class);
        System.out.println(Arrays.asList(annotations));

        annotations = AnnotationHelper.getDeclaredAnnotations(ma);
        System.out.println(Arrays.asList(annotations));
    }



    @Test
    public void annotationAttributeUsage() throws Exception{
        Map<Class<? extends Annotation>, AnnotationAttribute> attrs= AnnotationAttributeHelper.from(A.class);
        System.out.println(attrs);
        String xx =(String) attrs.get(XX.class).getAttribute("xx");
        System.out.println(xx);

        attrs= AnnotationAttributeHelper.from(B.class);
        xx =(String) attrs.get(XX.class).getAttribute("xx");
        System.out.println(xx);

        Method ma =A.class.getDeclaredMethod("ab");
        attrs= AnnotationAttributeHelper.from(ma);
        String yy =(String) attrs.get(YY.class).getAttribute("yy");
        System.out.println(yy);

        Method mb =B.class.getDeclaredMethod("ab");
        attrs= AnnotationAttributeHelper.from(mb);
        yy =(String) attrs.get(YY.class).getAttribute("yy");
        System.out.println(yy);

        Method mc =C.class.getDeclaredMethod("c");
        attrs= AnnotationAttributeHelper.from(mc);
        System.out.println(attrs);
        xx =(String) attrs.get(XX.class).getAttribute("xx");
        System.out.println(xx);

        Method zz = ZZ.class.getDeclaredMethod("zz");
        Map<Class<? extends Annotation>, Set<String>> sameAttributes = AnnotationAttributeHelper.fromSameAs(zz);
        System.out.println(sameAttributes);
    }

}
