package top.mowang.springboot2_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mowang.springboot2_project.pojo.User;
import top.mowang.springboot2_project.service.UserService;

import java.util.List;

/**
 * SpringBoot2-quick-start
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/16 13:08
 **/
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/getUserAll")
    public List<User> getUserAll(){
        return userService.getUserAll();
    }

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable Integer id){
        return userService.getUser(id);
    }

    @PostMapping("/saveUser")
    public User saveUser(User user){
        userService.saveUser(user);
        return user;
    }
}
