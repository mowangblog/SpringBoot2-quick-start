package top.mowang.springboot2_project.expection;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * SpringBoot2-quick-start
 *  自定义异常处理解析器
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/15 22:06
 **/
@Order(value = Ordered.HIGHEST_PRECEDENCE)
@Component
public class CustomHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        try {
            response.sendError(520,"我爱你的异常");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView();
    }
}
