package top.mowang.springboot2_project.controller;

import cn.hutool.Hutool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * SpringBoot2-quick-start
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/15 15:04
 **/
@Controller
public class IndexController {

    @RequestMapping(value = {"/","/login"})
    public String index(){
        return "login";
    }

    @PostMapping("/login")
    public String login(String username,String password){

        //登录成功重新向防止表单重复提交
        return "redirect:index.html";
    }

    @GetMapping("/index.html")
    public String goIndex(){
        return "index";
    }
}
