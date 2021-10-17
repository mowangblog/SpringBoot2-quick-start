package top.mowang.springboot2_startup.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.mowang.mowangspringbootstarterautoconfigure.service.HelloService;

import java.util.jar.JarEntry;

/**
 * SpringBoot2-quick-start
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/17 14:20
 **/
@Configuration
public class HelloConfig {

    @Bean
    public HelloService helloService(){
        HelloService helloService = new HelloService();
        return helloService;
    }
}
