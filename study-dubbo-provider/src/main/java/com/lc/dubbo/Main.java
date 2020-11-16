package com.lc.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.URL;
import java.util.Enumeration;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws Exception {
        Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources("conf/dubbo.properties");
        // JVM参数：-Ddubbo.properties.file=conf/dubbo.properties
        // Enumeration<URL> urls = ClassHelper.getClassLoader().getResources(System.getProperty("dubbo.properties.file"));
        while (urls.hasMoreElements()) {
            System.out.println(urls.nextElement().getPath());
            //System.out.println(urls.nextElement().getRef());
        }

        System.out.println("启动dubbo服务...");
        new ClassPathXmlApplicationContext("classpath:spring/application-context.xml");
        System.out.println("启动dubbo服务成功!");
        TimeUnit.SECONDS.sleep(3600L);
    }
}
