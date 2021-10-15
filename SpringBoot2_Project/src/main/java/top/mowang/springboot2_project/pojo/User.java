package top.mowang.springboot2_project.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * SpringBoot2-quick-start
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/15 15:27
 **/
@Data
@AllArgsConstructor
public class User {
    private String username;
    private String password;
}
