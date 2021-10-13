package top.mowang.springboot2_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import top.mowang.springboot2_web.pojo.Person;

/**
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/13 23:53
 **/
@SpringBootApplication
public class SpringBoot2WebApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringBoot2WebApplication.class, args);
        Person person = run.getBean("person", Person.class);
        System.out.println(person);
    }

}
