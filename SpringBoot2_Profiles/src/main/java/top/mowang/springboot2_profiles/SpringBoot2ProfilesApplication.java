package top.mowang.springboot2_profiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;

import java.util.Map;

@SpringBootApplication
public class SpringBoot2ProfilesApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringBoot2ProfilesApplication.class, args);
        ConfigurableEnvironment environment = run.getEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();
        Map<String, Object> systemEnvironment = environment.getSystemEnvironment();
        System.out.println("propertySources = " + propertySources);
        System.out.println("systemEnvironment = " + systemEnvironment);
    }

}
