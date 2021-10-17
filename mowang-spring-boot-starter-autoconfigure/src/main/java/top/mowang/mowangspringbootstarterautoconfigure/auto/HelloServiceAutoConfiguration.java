package top.mowang.mowangspringbootstarterautoconfigure.auto;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.mowang.mowangspringbootstarterautoconfigure.bean.HelloProperties;
import top.mowang.mowangspringbootstarterautoconfigure.service.HelloService;

/**
 * SpringBoot2-quick-start
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/17 13:56
 **/
@Configuration
@EnableConfigurationProperties(HelloProperties.class)
public class HelloServiceAutoConfiguration {

    @ConditionalOnMissingBean(HelloService.class)
    @Bean
    public HelloService helloService(){
        HelloService helloService = new HelloService();
        return helloService;
    }

}
