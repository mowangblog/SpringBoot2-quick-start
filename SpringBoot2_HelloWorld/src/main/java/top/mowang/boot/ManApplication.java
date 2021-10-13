package top.mowang.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import top.mowang.boot.pojo.User;

import java.util.Arrays;

/**
 * SpringBoot2-quick-start
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/13 16:21
 **/
@SpringBootApplication
public class ManApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ManApplication.class, args);
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        Arrays.sort(beanDefinitionNames);
        int i=0;
        for (String name : beanDefinitionNames) {
            System.out.println(++i + "\t" +name);
        }
        User user = run.getBean("User", User.class);
        User user2 = run.getBean("User", User.class);
        System.out.println(user.hashCode());
        System.out.println(user2.hashCode());


    }
}
