package com.chuan.simple.bean.example.helper;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import org.junit.Test;

import com.chuan.simple.helper.method.MethodHelper;
import com.chuan.simple.helper.proxy.ProxyHelper;

public class ProxyExample {

    public  interface A{
        String a();
        void a(String s);

    }
    public abstract static class B{

        String b(){
            System.out.println("original method b");
            return "bbbb";
        }
        void b(String s){
            System.out.println("original method b");
        }

    }

    public abstract static class C{

        public C(){
        }

        protected String c(){
            System.out.println("original method c");
            return "cc";
        }
        protected void c(String s){
            System.out.println("original method c:"+s);
        }

        protected void c(String s,long l){
            System.out.println("original method c:"+s+l);
        }

        protected abstract void c(String s,String ss,String sss);

    }

    public static class D{

        public D(){
            System.out.println("I'm the proxy Constructor");
        }

        public D(long l){
            System.out.println("I'm the proxy Constructor "+l);
        }

        protected String d(){
            System.out.println("proxy me");
            return "Dd";
        }
        public void d(String s){
            System.out.println("proxy me "+s);
        }
        public void d(String s,long l){
            System.out.println("proxy me "+s +l);
        }

    }

    public  interface E{
        default  void e(){
            System.out.println("I'm default method");
        }

    }


    public class HandlerA implements InvocationHandler{
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("This is my invocation handler");
            System.out.println("The args is "+ Arrays.asList(args));
            return "me";
        }
    }
    public class HandlerB implements InvocationHandler{
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("This is my invocation handler");
            System.out.println("The args is "+ Arrays.asList(args));
            Object result=null;
            if (method==null) {
            System.out.println("parent method is abstract");
            }
            else
            result= method.invoke(proxy,args);
            System.out.println("I know the result is:"+result);
            return result;
        }
    }
    public class HandlerC implements InvocationHandler{
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println();
            System.out.println("method:"+method);
            System.out.println("I will proxy all executable(Constructor/Method)");
            System.out.println("Proxy args is "+ Arrays.asList(args));
            Object result = method.invoke(proxy,args);
            System.out.println("I know the proxy result is:"+result);
            return result;
        }
    }

    @Test
    public void proxyUsage() throws  Exception{

        String result;
        //Instance interface
        System.out.println("-------------Instance interface-------------");
        A a =(A) ProxyHelper.instance(new HandlerA(),new Class[]{A.class});
        result = a.a();
        System.out.println(result);
        a.a("aaaaa");
        System.out.println(a);

        //Override class
        System.out.println("-------------Override Class-------------");
        C c  =(C) ProxyHelper.instance(new HandlerB(),C.class,C.class.getDeclaredMethods(),new Class<?>[0]);
        result = c.c();
        c.c("c");
        c.c("cccc",1);
        c.c("1","2","3");
        System.out.println(result);
        System.out.println(c);

        //Proxy instance
        System.out.println("--------------Proxy class---------------");
        Object d = ProxyHelper.proxy(D.class,new HandlerC());
        System.out.println(D.class.isInstance(d));
        MethodHelper.invoke(d,"d");
        MethodHelper.invoke(d,"d","smmmmm");
        MethodHelper.invoke(d,"d","Sdddd",122l);

        //Proxy class
        System.out.println("--------------Proxy class---------------");
        Class<?> clazz = ProxyHelper.proxyClass(D.class,new HandlerC());
        Constructor<?> ctor = clazz.getDeclaredConstructor(long.class);
        d = ctor.newInstance(12344);
        MethodHelper.invoke(d,"d","Sdddd",122l);


        //Override default method
        System.out.println("-------------Override default method-------------");
        E e =(E) ProxyHelper.instance(new HandlerC(),new Class[]{E.class});
        e.e();

    }

    @Test
    @Deprecated
    public void proxyFunctionalTest() throws  Exception{
        //Instance java.* package
        System.out.println("-------------Instance java.* package-------------");
        Object o = ProxyHelper.instance(new HandlerA(),Object.class,new Class[]{});
        System.out.println(o);
        //Proxy java.* package
        System.out.println("-------------Proxy java.* package-------------");
        o = ProxyHelper.proxy(HashSet.class,new HandlerB());
        System.out.println(o);
    }


    public static class F{
        public void fg(){
            System.out.println("fg-F");
        }
    }

    public static class G{

        public void fg(){
            System.out.println("fg-G");
        }

    }



    public class HandlerD implements InvocationHandler{
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("wrap handler");
            System.out.println("The args is "+ Arrays.asList(args));
            System.out.println("proxy to "+proxy+":"+method);
            return method.invoke(proxy,args);
        }
    }



    @Test
    public void wrapFunctionalUsage()throws Exception{
        /**
         * Wrap object as F
         */
        System.out.println("---------Wrap object as F------------");
        Object o  = new Object();
        System.out.println(o);
        F f = (F)ProxyHelper.wrap(F.class,o,new HandlerD());
        System.out.println(f);
        System.out.println(f.getClass());
        /**
         * Wrap F as G
         */
        System.out.println("---------Wrap F as G------------");
        F ff = new F();
        System.out.println(ff);
        ff.fg();
        G g = (G)ProxyHelper.wrap(G.class,ff,new HandlerD());
        System.out.println(g);
        g.fg();
    }



}
