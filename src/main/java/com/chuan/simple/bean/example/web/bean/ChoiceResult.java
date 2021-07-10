package com.chuan.simple.bean.example.web.bean;

import java.util.List;

public class ChoiceResult {

    private String choice;
    
    private List<Choice> others;
    
    public ChoiceResult(String choice,List<Choice> others) {
        this.choice=choice;
        this.others=others;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public List<Choice> getOthers() {
        return others;
    }

    public void setOthers(List<Choice> others) {
        this.others = others;
    }
    
    
    
}
