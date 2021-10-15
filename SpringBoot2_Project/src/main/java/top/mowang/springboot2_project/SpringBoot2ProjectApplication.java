package top.mowang.springboot2_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * SpringBoot2ProjectApplication
 *	ServletComponentScan指定原生servlet组件位置
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/15 14:55
 **/
@ServletComponentScan(basePackages = "top.mowang")
@SpringBootApplication
public class SpringBoot2ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2ProjectApplication.class, args);
	}

}
