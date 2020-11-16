package com.lc.dubbo;

import com.lc.dubbo.contract.HelloContract;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    private static ExecutorService executor = new ThreadPoolExecutor(200,
            200,
            3000,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(10000));

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/application-context.xml");
        applicationContext.start();

        HelloContract helloContract = (HelloContract) applicationContext.getBean("helloContract");

        System.out.println(helloContract.sayHello("zs"));
        System.out.println(helloContract.getName(1234567890L));

        for (;;) {
            try {
                executor.execute(() -> {
                    System.out.println(helloContract.getName(1234567890L));
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
            TimeUnit.MILLISECONDS.sleep(1000L);
        }
    }
}
