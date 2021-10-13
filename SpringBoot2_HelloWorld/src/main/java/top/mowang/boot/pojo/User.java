package top.mowang.boot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * SpringBoot2-quick-start
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/13 17:22
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String password;
    private String email;
    private Double money;
}
