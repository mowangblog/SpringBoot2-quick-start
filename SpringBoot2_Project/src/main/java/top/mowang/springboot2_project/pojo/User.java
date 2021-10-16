package top.mowang.springboot2_project.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * MyBatis-Demo
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/10 18:07
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_user")
public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private Double money;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
