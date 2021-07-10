package com.chuan.simple.bean.example.code;

import java.io.File;
import org.junit.Test;

import com.chuan.simple.bean.core.config.loader.SimpleLoader;
import com.chuan.simple.bean.core.config.node.NodeWrapper;
import com.chuan.simple.helper.resource.Resource;

public class SimpleLoaderTest {

    @Test
    public void testLogogram() throws Exception {
        NodeWrapper root = new SimpleLoader().load(new Resource(new File(ClassLoader.getSystemResource("code/code-test.sp").getFile())));
        System.out.println(root);
    }
    
}
