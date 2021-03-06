package top.mowang.springboot2_project.controller;

import cn.hutool.Hutool;
import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.mowang.springboot2_project.pojo.User;

import javax.servlet.http.HttpSession;

/**
 * SpringBoot2-quick-start
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/15 15:04
 **/
@Controller
public class IndexController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/sql")
    @ResponseBody
    public String selectCount(){
        Long count = jdbcTemplate.queryForObject("select count(*) from t_user", Long.class);
        return count.toString();
    }

    @RequestMapping(value = {"/", "/login"})
    public String index() {
        return "login";
    }

    @PostMapping("/login")
    public String login(User user, HttpSession session, Model model) {
        if (StrUtil.isEmpty(user.getUsername()) || StrUtil.isEmpty(user.getPassword())) {
            model.addAttribute("msg", "账号密码不能为空");
            return "/login";
        }
        String password = "123456";
        if (password.equals(user.getPassword())) {
            session.setAttribute("user", user);
            //登录成功重新向防止表单重复提交
            return "redirect:index.html";
        } else {
            model.addAttribute("msg", "账号密码错误");
            return "/login";
        }

    }

    @GetMapping("/index.html")
    public String goIndex(HttpSession session, Model model) {
        return "index";
    }

    @GetMapping("/index")
    public String goIndex2(HttpSession session, Model model) {
        return "index";
    }

    @GetMapping("/getError")
    public String getError(HttpSession session, Model model) {
        int i = 10 / 0;
        return "index";
    }

}
