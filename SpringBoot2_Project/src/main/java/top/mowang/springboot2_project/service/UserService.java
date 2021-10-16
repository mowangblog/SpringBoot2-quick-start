package top.mowang.springboot2_project.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import top.mowang.springboot2_project.pojo.User;

import java.util.List;

public interface UserService extends IService<User> {
    public List<User> getUserAll();


    public User getUser(Integer id);

    public void saveUser(User user);
}
