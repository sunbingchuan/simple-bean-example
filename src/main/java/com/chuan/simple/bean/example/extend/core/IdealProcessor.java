package com.chuan.simple.bean.example.extend.core;

import java.util.Collection;

import com.chuan.simple.bean.core.build.builder.Builder;
import com.chuan.simple.bean.core.element.entity.FieldElement;
import com.chuan.simple.bean.core.processor.Processor;
import com.chuan.simple.bean.example.extend.bean.Ideal;

public class IdealProcessor implements Processor {

    private String wing;
    
    public IdealProcessor(String wing) {
        this.wing=wing;
    }
    
    @Override
    public void processBuilders(Collection<Builder<?>> builders) {
        for (Builder<?> builder : builders) {
            if (Ideal.class.isAssignableFrom(builder.getBuilderClass())) {
                FieldElement fieldElement = new FieldElement(
                        builder.getBuilderClass().getName(), "wing");
                fieldElement.setValue(wing);
                builder.addElement(fieldElement);
            }
        }
    }
    
}
