package top.mowang.springboot2_profiles.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * SpringBoot2-quick-start
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/16 23:58
 **/
@Data
@Component
@Profile(value = {"prod","test"})
@ConfigurationProperties(prefix = "myuser")
public class User {
    private String username;
    private String password;
}
