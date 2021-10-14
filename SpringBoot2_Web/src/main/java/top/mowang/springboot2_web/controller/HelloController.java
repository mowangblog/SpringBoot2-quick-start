package top.mowang.springboot2_web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping(value = "/user")
    public String getUser(){
        return "GET-张三";
    }

    @PostMapping(value = "/user")
    public String saveUser(){
        return "POST-张三";
    }


    @PutMapping(value = "/user")
    public String putUser(){
        return "PUT-张三";
    }

    @DeleteMapping(value = "/user")
    public String deleteUser(){
        return "DELETE-张三";
    }

}
