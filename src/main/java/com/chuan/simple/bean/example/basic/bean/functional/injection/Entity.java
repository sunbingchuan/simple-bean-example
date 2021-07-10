package com.chuan.simple.bean.example.basic.bean.functional.injection;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Entity {

    Object[] contents;
    
    Map map;
    
    List list;
    
    Set set;

    Map<String,Object> mapType;

    
    Object object;
    
    boolean only = false;
    
    
    
    private Entity() {
        this.only=true;
    }
    
    private Entity(Object[] contents) {
        this.contents=contents;
    }

   
    
    private Entity(Map<String,Object> mapType,Entity object) {
        this.mapType=mapType;
        this.object=object;
    }
    
    private Entity(Map map) {
        this.map=map;
    }
    
    private Entity(List list) {
        this.list=list;
    }
    private Entity(Set set) {
        this.set=set;
    }

    
    @Override
    public String toString() {
        if (only) {
            return "entity";
        }
        return "\ncontents:"+toString(contents)
        +"\nlist:"+list
        +"\nset:"+set
        +"\nmap:"+map
        +"\nobject:"+object
        +"\nmapType:"+mapType;
    }
    
    public String toString(Object[] array) {
        if (array == null) {
            return null;
        }
        StringBuffer sb  = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < contents.length; i++) {
            if (i!=0) {
                sb.append(",");
            }
            if (array[i] instanceof Object[]) {
                sb.append(toString((Object[])array[i]));
            }else {
                sb.append(array[i]);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public Map<String, Object> getMapType() {
        return mapType;
    }

    public void setMapType(Map<String, Object> mapType) {
        this.mapType = mapType;
    }
    
}
