package top.mowang.boot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mowang.boot.pojo.Car;

/**
 * SpringBoot2-quick-start
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/13 16:30
 **/
@Slf4j
@RestController
public class HelloController {

    @Autowired
    Car car;

    @RequestMapping("/")
    public String hello(){
        log.info("方法进入开始执行逻辑 info");
        log.trace("方法进入开始执行逻辑 trace");
        log.debug("方法进入开始执行逻辑 debug");
        log.warn("方法进入开始执行逻辑 warn");
        log.error("方法进入开始执行逻辑 error");
        return "hello SpringBoot2";
    }

    @RequestMapping("/car")
    public Car car(){
        return car;
    }
}
