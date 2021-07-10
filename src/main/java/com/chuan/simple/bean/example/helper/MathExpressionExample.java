package com.chuan.simple.bean.example.helper;

import org.junit.Test;

import com.chuan.simple.helper.expression.math.MathExpressionHelper;

import java.math.BigDecimal;

public class MathExpressionExample {
    @Test
    public void parseExpressionUsage(){
        /**
         * Math operation:'+','-','*','/','%'
         * Bit operation:'~','|','^','&','<<','>>','>>>'
         * Compare operation:'>','<','>=','<=','!=','=='
         * Bool operation:'&','&&','|','||','^','!'
         */
        //Math operation
        String result;
        System.out.println("-------------Math operation-------------");
        System.out.println("(1+1)*(168-15)/7.0%10");
        System.out.println((1+1)*(168-15)/7.0%10);
        result =MathExpressionHelper.parseExpression("(1+1)*(168-15)/7.0%10");
        System.out.println(result);

        System.out.println("(1+1)*(168-15)/7%10");
        System.out.println((1+1)*(168-15)/7%10);
        result =MathExpressionHelper.parseExpression("(1+1)*(168-15)/7%10");
        System.out.println(result);
        MathExpressionHelper.getContext().setScale(0);
        MathExpressionHelper.getContext().setRoundingMode(BigDecimal.ROUND_DOWN);
        result =MathExpressionHelper.parseExpression("(1+1)*(168-15)/7%10");
        System.out.println(result);

        MathExpressionHelper.getContext().setScale(32);
        MathExpressionHelper.getContext().setRoundingMode(BigDecimal.ROUND_HALF_UP);
        //Bit operation
        System.out.println("-------------Bit operation-------------");
        System.out.println(-~((1899&(133|12)^1)<<8>>1)>>>1);
        result = MathExpressionHelper.parseExpression("-~((1899&(133|12)^1)<<8>>1)>>>1");
        System.out.println(result);
        //Compare operation & Bool operation
        System.out.println("-------------Compare operation & Bool operation-------------");
        System.out.println((100>2&1<0)&true|false&1>1|1<2);
        result = MathExpressionHelper.parseExpression("(100>2&1<0)&true|false&1>1|1<2");
        System.out.println(result);
        //Mixed operation
        System.out.println("------------- Mixed operation -------------");
        System.out.println(((1+1)*(168-15)/7.0%10<-~((1899&(133|12)^1)<<8>>1)>>>1)&(100>2&1>0)&(true|false)&1>0);
        result = MathExpressionHelper.parseExpression("((1+1)*(168-15)/7.0%10<-~((1899&(133|12)^1)<<8>>1)>>>1)&(100>2&1>0)&(true|false)&1>0");
        System.out.println(result);
        //Different radix
        System.out.println("-------------Different radix-------------");
        System.out.println("(0xal+1)*(169990l-0b11+0777)/7.0%10");
        System.out.println((0xal+1)*(169990l-0b11+0777)/7.0%10);
        result = MathExpressionHelper.parseExpression("(0xal+1)*(169990l-0b11+0777)/7.0%10");
        System.out.println(result);

    }

}
