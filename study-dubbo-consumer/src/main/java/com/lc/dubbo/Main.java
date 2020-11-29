package com.lc.dubbo;

import com.alibaba.dubbo.rpc.RpcContext;
import com.lc.dubbo.contract.HelloContract;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/application-context.xml");
        applicationContext.start();

        HelloContract helloContract = (HelloContract) applicationContext.getBean("helloContract");

        System.out.println(helloContract.sayHello("zs"));
        System.out.println(helloContract.getName(1234567890L));

        Future<String> future = RpcContext.getContext().getFuture();

        new Thread(() -> {
            try {
                System.out.println(future.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        System.out.println(future.get());
    }
}
