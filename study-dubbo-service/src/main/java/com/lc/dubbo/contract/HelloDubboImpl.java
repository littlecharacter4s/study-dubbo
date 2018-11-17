package com.lc.dubbo.contract;

import com.lc.dubbo.service.HelloService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by daojia on 2017-7-3.
 */
@Service("helloDubbo")
public class HelloDubboImpl implements HelloDubbo {
    @Resource
    private HelloService helloService;

    @Override
    public String sayHello(String name) {
        return helloService.sayHello(name);
    }
}
