package top.mowang.springboot2_project.dao;


import org.apache.ibatis.annotations.*;
import org.yaml.snakeyaml.events.Event;
import top.mowang.springboot2_project.pojo.User;

import java.util.List;

@Mapper
public interface UserDao {

    public List<User> getUserAll();

    public User getUser(Integer id);

    /**
     * @description: 使用mybatis注解的方式插入数据,并设置自增键回显
     * @author: Xuan Li
     * @date: 2021/10/16 15:04
    */
    @Insert("insert into t_user(username,password,email,money) values(#{user.username},#{user.password},#{user.email},#{user.money})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public void saveUser(@Param("user") User user);
}
