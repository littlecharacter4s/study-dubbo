package com.lc.dubbo;

import com.lc.dubbo.contract.HelloContract;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RestController
public class StartController {
    @Resource
    private HelloContract helloContract;


    @RequestMapping("/start/{interval}")
    public String start(@PathVariable Long interval) throws InterruptedException {
        System.out.println(helloContract.sayHello("zs"));
        System.out.println(helloContract.getName(1234567890L));

        new Thread(new Runnable() {
            private ExecutorService executor = new ThreadPoolExecutor(200,
                    200,
                    3000,
                    TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<>(10000));

            @Override
            public void run() {
                for (;;) {
                    try {
                        executor.execute(() -> {
                            System.out.println(helloContract.getName(1234567890L));
                        });
                        TimeUnit.MILLISECONDS.sleep(interval);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        return "SUCCESS";
    }
}
