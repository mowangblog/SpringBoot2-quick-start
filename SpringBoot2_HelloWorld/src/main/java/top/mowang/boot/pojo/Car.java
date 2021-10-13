package top.mowang.boot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * SpringBoot2-quick-start
 *  只有在容器中的组件，才会拥有SpringBoot提供的强大功能
 *  //@Component
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/13 17:57
 **/
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "mycar")
public class Car {

    private String brand;
    private Integer price;


}
