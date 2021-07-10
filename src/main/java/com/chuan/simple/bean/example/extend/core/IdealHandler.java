package com.chuan.simple.bean.example.extend.core;

import com.chuan.simple.bean.core.SimpleContext;
import com.chuan.simple.bean.core.config.node.Node;
import com.chuan.simple.bean.core.handler.Handler;

public class IdealHandler implements Handler {

    
    private SimpleContext context;
    
    
    
    @Override
    public void setContext(SimpleContext context) {
        this.context=context;
    }

    @Override
    public void handle(Node cfg) {
        String wing = cfg.attrString("wing");
        initProcessor(wing);
    }

    private void initProcessor(String wing) {
        this.context.addProcessor(new IdealProcessor(wing));
    }
    
}
