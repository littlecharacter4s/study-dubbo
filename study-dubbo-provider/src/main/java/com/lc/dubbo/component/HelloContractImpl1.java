package com.lc.dubbo.component;

import com.lc.dubbo.contract.HelloContract;
import com.lc.dubbo.service.HelloService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("helloContract1")
public class HelloContractImpl1 implements HelloContract {
    @Resource
    private HelloService helloService;

    @Override
    public String sayHello(String name) {
        return helloService.sayHello(name + "1");
    }
}
