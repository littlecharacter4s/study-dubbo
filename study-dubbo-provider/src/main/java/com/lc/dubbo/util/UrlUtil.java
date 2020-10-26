package com.lc.dubbo.util;

import com.alibaba.dubbo.common.URL;

public class UrlUtil {
    public static void main(String[] args) {
        String url = "dubbo://192.168.75.1:20881/com.lc.dubbo.contract.HelloContract?anyhost=true&application=study-dubbo-provider&bind.ip=192.168.75.1&bind.port=20881&dubbo=2.6.2&generic=false&group=group_hello_1&interface=com.lc.dubbo.contract.HelloContract&methods=getName,sayHello&monitor=dubbo%3A%2F%2Fzk%3A2181%2Fcom.alibaba.dubbo.registry.RegistryService%3Fapplication%3Dstudy-dubbo-provider%26backup%3Dzk%3A2182%2Czk%3A2183%26dubbo%3D2.6.2%26group%3Ddubbo_study%26owner%3Dgujx%2Cxx%26pid%3D125248%26protocol%3Dregistry%26refer%3Ddubbo%253D2.6.2%2526interface%253Dcom.alibaba.dubbo.monitor.MonitorService%2526pid%253D125248%2526timestamp%253D1590033866395%26registry%3Dzookeeper%26timestamp%3D1590033865950&owner=gujx,xx&pid=125248&side=provider&timestamp=159003386598";
        System.out.println(URL.decode(url));
    }
}
