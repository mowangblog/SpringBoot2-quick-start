package top.mowang.springboot2_project.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import top.mowang.springboot2_project.expection.UserTooManyException;
import top.mowang.springboot2_project.pojo.User;
import top.mowang.springboot2_project.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

/**
 * SpringBoot2-quick-start
 *
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/15 16:51
 **/
@Controller
@SuppressWarnings("all")
public class TableController {

    @Autowired
    UserService userService;

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Integer id,
                             @RequestParam(value = "currentPage",defaultValue = "1") Integer currentPage,
                             RedirectAttributes redirectAttributes){
        userService.removeById(id);
        redirectAttributes.addAttribute("currentPage",currentPage);
        return "redirect:/dynamic_table";
    }

    @GetMapping("/basic_table")
    public String basic_table(HttpSession session,Model model){
        return "table/basic_table";
    }
    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize,
                                @RequestParam(value = "currentPage",defaultValue = "1") Integer currentPage,
                                HttpSession session,
                                Model model){
//        //表格内容的遍历
//        List<User> users = Arrays.asList(new User("zhangsan", "123456"),
//                new User("lisi", "123444"),
//                new User("haha", "aaaaa"),
//                new User("hehe ", "aaddd"));
//        if(users.size()>3){
//            throw new UserTooManyException();
//        }
//        model.addAttribute("users",users);

        Page<User> page = new Page<>(currentPage,2);
        Page<User> userPage = userService.page(page,null);
        model.addAttribute("users",userPage);
        return "table/dynamic_table";
    }
    @GetMapping("/editable_table")
    public String editable_table(HttpSession session,Model model){
        return "table/editable_table";
    }
    @GetMapping("/responsive_table")
    public String responsive_table(HttpSession session,Model model){
        return "table/responsive_table";
    }
}
