package top.mowang.mowangspringbootstarterautoconfigure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import top.mowang.mowangspringbootstarterautoconfigure.bean.HelloProperties;

/**
 * SpringBoot2-quick-start
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/17 13:50
 **/
public class HelloService {

    @Autowired
    HelloProperties helloProperties;

    public String sayHello(String userName){
        return helloProperties.getPrefix()+"》"+userName+"》"+helloProperties.getSuffix();
    }
}
