package top.mowang.springboot2_project.expection;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * SpringBoot2-quick-start
 *  全局异常处理
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/15 21:40
 **/
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ArithmeticException.class,NullPointerException.class})
    public String handlerArithmeticException(Exception e){
        log.error("异常是:{}",e.getMessage());
        return "index";
    }
}
