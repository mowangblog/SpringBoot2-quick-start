package top.mowang.springboot2_project;

import org.mybatis.spring.annotation.MapperScan;
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
@MapperScan("top.mowang.springboot2_project.dao") //配置之后可以不用每个mapper都设置@mapper
@ServletComponentScan(basePackages = "top.mowang")
@SpringBootApplication
public class SpringBoot2ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2ProjectApplication.class, args);
	}

}
