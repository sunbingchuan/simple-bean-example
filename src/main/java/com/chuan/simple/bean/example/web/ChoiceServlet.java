package com.chuan.simple.bean.example.web;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.chuan.simple.bean.annotation.Autowired;
import com.chuan.simple.bean.example.web.bean.Choice;
import com.chuan.simple.bean.example.web.bean.ChoiceResult;
import com.chuan.simple.bean.example.web.bean.ChoiceService;
import com.chuan.simple.bean.example.web.bean.Question;
import com.chuan.simple.web.annotation.JSONBody;
import com.chuan.simple.web.annotation.Request;
import com.chuan.simple.web.annotation.Servlet;

@Servlet
public class ChoiceServlet {
    
    @Autowired
    private ChoiceService choiceService;
    
    @Request("/chooseSecond")
    public void  choose(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.getWriter().print("Choose hard work!");
            response.getWriter().print(choiceService.choice());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * The request json may be:
     * <pre/>
     * {
     *      "a":"Who am i?",
     *      "b":"Who are you?",
     *      "c":"Where am i?"
     *  }
     * </pre>
     */
    @Request("/chooseFrist")
    @JSONBody
    public ChoiceResult  choose(HttpServletRequest request,@JSONBody Question question) {
        try {
            System.out.println(request);
            System.out.println("You question is:");
            System.out.println(JSON.toJSONString(question));
            Choice a = new Choice("money");
            Choice b = new Choice("life");
            return new ChoiceResult("soul", Arrays.asList(a,b));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * The request form data may be:
     * <pre/>
     * a:i am a
     * b:i am b
     * c:i am c
     * c:i am c
     * </pre>
     */
    @Request("/chooseThird")
    public ChoiceResult  choose(String a,String b,String[] c) {
        try {
            System.out.println(a);
            System.out.println(b);
            System.out.println(Arrays.asList(c));
            return new ChoiceResult(a, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
