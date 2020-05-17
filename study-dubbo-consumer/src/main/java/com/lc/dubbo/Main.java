package com.lc.dubbo;

import com.lc.dubbo.contract.HelloContract;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/application-context.xml");
        HelloContract helloContract = (HelloContract) applicationContext.getBean("helloContract");
        System.out.println(helloContract.sayHello("zs"));
        applicationContext.start();
    }
}
