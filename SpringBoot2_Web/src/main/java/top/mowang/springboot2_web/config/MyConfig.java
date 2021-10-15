package top.mowang.springboot2_web.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;
import top.mowang.springboot2_web.converter.MyConverter;
import top.mowang.springboot2_web.pojo.Pet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * SpringBoot2-quick-start
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/14 14:54
 **/
@Data
@Component
@Configuration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = "myconfig")
public class MyConfig /*implements WebMvcConfigurer */{

    public String methodParam = "_method";
    public boolean RemoveSemicolonContent = true;

    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        hiddenHttpMethodFilter.setMethodParam(methodParam);
        return hiddenHttpMethodFilter;
    }

    /**
     * 配置可以使用矩阵变量，使用ConfigurationProperties让我们可以在配置文件中配置参数
     * addFormatters 里面 registry.addConverter 添加自定义类型转换器 String转换为pet
     * @description:
     * @author: Xuan Li
     * @date: 2021/10/14 18:16
    */
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {

            //自定义format类型
            @Override
            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
                Map<String, MediaType> mediaTypes = new HashMap<>();
                mediaTypes.put("json",MediaType.APPLICATION_JSON);
                mediaTypes.put("xml",MediaType.APPLICATION_XML);
                mediaTypes.put("mowang",MediaType.parseMediaType("application/mowang"));
                ParameterContentNegotiationStrategy strategy =
                        new ParameterContentNegotiationStrategy(mediaTypes);
//                strategy.setParameterName("ff");
                HeaderContentNegotiationStrategy headerStrategy = new HeaderContentNegotiationStrategy();
                configurer.strategies(Arrays.asList(strategy,headerStrategy) );
            }

            //添加自定义数据类型转换器
            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
                converters.add(new MyConverter());
            }
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                urlPathHelper.setRemoveSemicolonContent(RemoveSemicolonContent);
                configurer.setUrlPathHelper(urlPathHelper);
            }
            //添加自定义类型转换器 String转换为pet
            @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverter(new Converter<String, Pet>() {
                    @Override
                    public Pet convert(String source) {
                        Pet pet = new Pet();
                        String[] split = source.split(",");
                        pet.setName(split[0]);
                        pet.setWeight(Double.parseDouble(split[1]));
                        return pet;
                    }
                });
            }

        };
    }

//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        UrlPathHelper urlPathHelper = new UrlPathHelper();
//        urlPathHelper.setRemoveSemicolonContent(false);
//        configurer.setUrlPathHelper(urlPathHelper);
//    }
}
