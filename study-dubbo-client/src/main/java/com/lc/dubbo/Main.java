package com.lc.dubbo;

import com.lc.dubbo.contract.HelloDubbo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        HelloDubbo helloDubbo = (HelloDubbo) applicationContext.getBean("helloDubbo");
        System.out.println(helloDubbo.sayHello("zs"));
    }
}
