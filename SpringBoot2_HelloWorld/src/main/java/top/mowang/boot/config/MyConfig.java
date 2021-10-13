package top.mowang.boot.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.mowang.boot.pojo.Car;
import top.mowang.boot.pojo.User;

/**
 * 1、配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2、配置类本身也是组件
 * 3、proxyBeanMethods：代理bean的方法
 *      Full(proxyBeanMethods = true)、【保证每个@Bean方法被调用多少次返回的组件都是单实例的】
 *      Lite(proxyBeanMethods = false)【每个@Bean方法被调用多少次返回的组件都是新创建的】
 *      组件依赖必须使用Full模式默认。其他默认是否Lite模式
 *
 * 4、@Import({User.class, DBHelper.class})
 *  给容器中自动创建出这两个类型的组件、默认组件的名字就是全类名
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/13 17:28
 **/
//@ImportResource("classpath:beans.xml")原生配置文件引入
@SuppressWarnings("all")
@Configuration(proxyBeanMethods = false)
//条件装配@ConditionalOnBean(name = "tom") 必须有tom的bean
//必须没有tom的bean
@ConditionalOnMissingBean(name = "tom")
@EnableConfigurationProperties(Car.class)
public class MyConfig {

    /**
     * Full:外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例对象
     *  给容器中添加组件。以方法名作为组件的id。返回类型就是组件类型。返回的值，就是组件在容器中的实例
     * @return
     */
    @Bean
    public User User(){
        return new User(1,"lixuan","12324","dsrfae@qq.com",111.2);
    }
}
