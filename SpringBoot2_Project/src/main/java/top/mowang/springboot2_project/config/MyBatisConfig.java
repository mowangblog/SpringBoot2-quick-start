package top.mowang.springboot2_project.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * SpringBoot2-quick-start
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/16 16:33
 **/
@Configuration
public class MyBatisConfig {

    /**
     * @description: mybatisPlusInterceptor添加分页插件，添加拦截器，实现分页功能
     * @author: Xuan Li
     * @date: 2021/10/16 16:39
    */
    @Bean
   public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();

        PaginationInnerInterceptor interceptor = new PaginationInnerInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(interceptor);
        return mybatisPlusInterceptor;
    }
}
