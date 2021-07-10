package com.chuan.simple.bean.example.basic.bean.aspect;

public class LonelyPerson {

    public void defeat(String a) {
        System.out.println("Lonely person defeat "+a+"!"); 
    }
    public void defeat(String a,String b) {
        System.out.println("Lonely person defeat "+a+" and "+b+"!"); 
    }
    public void defeat(String a,String b,String c) {
        System.out.println("Lonely person defeat "+a+"、"+b+" and "+c+ "!"); 
    }
}
