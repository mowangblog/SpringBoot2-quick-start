package top.mowang.springboot2_project.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.mowang.springboot2_project.dao.UserDao;
import top.mowang.springboot2_project.pojo.User;

import java.util.List;

/**
 * SpringBoot2-quick-start
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/16 13:09
 **/
@Service
public class UserService {
    @Autowired
    UserDao mapper;

    public List<User> getUserAll(){
        List<User> userAll = mapper.getUserAll();
        return userAll;
    }


    public User getUser(Integer id){
        return mapper.getUser(id);
    }

    public void saveUser(User user){
        mapper.saveUser(user);
    }
}
