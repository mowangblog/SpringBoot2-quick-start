package top.mowang.springboot2_profiles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mowang.springboot2_profiles.pojo.User;

import java.util.Map;

/**
 * SpringBoot2-quick-start
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/16 23:58
 **/
@RestController
public class UserController {
    @Autowired
    User user;

    @Value("${myuser.name:下冰雹}")
    String name;

    /**
     * @description: 可以拿到系统的环境变量
     * @author: Xuan Li
     * @date: 2021/10/17 0:23
    */
    @Value("${JAVA_HOME}")
    String DEV_PATH;

    @Value("${os.name}")
    String osName;

    @GetMapping("/user")
    public User getUser(){
        return user;
    }
    @GetMapping("/getUserName")
    public String getUserName(){
        return name;
    }

    @GetMapping("/getJavaPath")
    public String getJavaPath(){
        return DEV_PATH;
    }

    @GetMapping("/getOsName")
    public String getOsName(){
        return osName;
    }

}
