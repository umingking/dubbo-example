package com.example.crawler;

import java.util.Arrays;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.MethodConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.example.crawler.demo.api.DemoApi;

/**
 * 
 * @author umingking
 * @desc 消费者直连指定ip的dubbo服务
 *
 */
public class DubboConsumer {

    /**
     * @param args
     */
    public static void main(String[] args) {
        testDubboDemo(); 
    }
    
    public static void testDubboDemo() {
        ApplicationConfig ac = new ApplicationConfig();
        ac.setName("crawler-demo-provider");
        ReferenceConfig<DemoApi> ref = new ReferenceConfig<>();
        ref.setInterface(DemoApi.class);
        ref.setUrl("dubbo://127.0.0.1:20880/com.example.crawler.demo.api.DemoApi");
        ref.setVersion("1.0.0");
        ref.setApplication(ac);
        MethodConfig mc = new MethodConfig();
        mc.setAsync(false);
        mc.setName("testDemo");
        ref.setMethods(Arrays.asList(new MethodConfig[]{mc}));
        
        System.out.println(ref.get().testDemo("你好，dubbo框架"));
    }

}

