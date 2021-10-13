package top.mowang.springboot2_web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mowang.springboot2_web.pojo.Person;

/**
 * SpringBoot2-quick-start
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/13 23:30
 **/

@RestController
public class HelloController {

    @Autowired
    Person person;

    @RequestMapping("/index")
    public Person hello(){
        return person;
    }

}
