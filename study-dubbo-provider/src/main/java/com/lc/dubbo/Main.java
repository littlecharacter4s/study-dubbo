package com.lc.dubbo;

import com.alibaba.dubbo.common.utils.ClassHelper;

import java.util.Enumeration;

public class Main {
    public static void main(String[] args) throws Exception {
//        System.out.println("启动dubbo服务...");
//        new ClassPathXmlApplicationContext("classpath:spring/application-context.xml");
//        System.out.println("启动dubbo服务成功!");
//        TimeUnit.SECONDS.sleep(1000L);
        //Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources("dubbo.properties");
        Enumeration<java.net.URL> urls = ClassHelper.getClassLoader().getResources(System.getProperty("dubbo.properties.file"));
        while (urls.hasMoreElements()) {
            System.out.println(urls.nextElement().getPath());
            //System.out.println(urls.nextElement().getRef());
        }
    }
}
