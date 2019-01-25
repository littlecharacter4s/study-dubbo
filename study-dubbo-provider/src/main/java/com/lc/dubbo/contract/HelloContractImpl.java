package com.lc.dubbo.contract;

import com.lc.dubbo.service.HelloService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("helloContract")
public class HelloContractImpl implements HelloContract {
    @Resource
    private HelloService helloService;

    @Override
    public String sayHello(String name) {
        return helloService.sayHello(name);
    }
}
