package top.mowang.springboot2_project.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
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
public class UserServiceImpl extends ServiceImpl<UserDao,User> implements UserService {
    @Autowired
    UserDao mapper;

    Counter counter;
    public UserServiceImpl(MeterRegistry meterRegistry){
        counter = meterRegistry.counter("UserService.method.getUserAll.running.counter");
    }

    @Override
    public List<User> getUserAll(){
        counter.increment();
        List<User> users = mapper.selectList(new QueryWrapper<>());
        return users;
    }


    @Override
    public User getUser(Integer id){
        return mapper.getUser(id);
    }

    @Override
    public void saveUser(User user){
        mapper.saveUser(user);
    }
}
