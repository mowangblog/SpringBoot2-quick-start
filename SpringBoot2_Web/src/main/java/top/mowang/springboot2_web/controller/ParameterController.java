package top.mowang.springboot2_web.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * SpringBoot2-quick-start
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/14 15:49
 **/
@RestController
public class ParameterController {

    @GetMapping("/user/{id}/{name}")
    public Map getUser(@PathVariable("id") Integer id,
                       @PathVariable("name") String name,
                       @PathVariable Map<String,String> pv,
                       @RequestHeader("User-Agent") String agent,
                       @RequestHeader Map<String,String> hv,
                       @RequestParam Map<String,String> kv,
                       @CookieValue("Idea-c928d5a5") String cookieValue,
                       @CookieValue("Idea-c928d5a5") Cookie cookie){

        HashMap<String, Object> map = new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        map.put("pv",pv);
        map.put("agent",agent);
        map.put("hv",hv);
        map.put("kv",kv);
        map.put("Idea-c928d5a5",cookieValue);
        System.out.println(cookie.getValue());

        return map;
    }

    @PostMapping("/getPost")
    public Map getPost(@RequestBody String content) throws UnsupportedEncodingException {
        HashMap<String, Object> map = new HashMap<>();
        map.put("content", URLDecoder.decode(content,"UTF-8"));
        return map;
    }

    //springboot默认禁用矩阵变量
    @GetMapping("/path/{id}")
    public Map getPath(@PathVariable("id") Integer id,
                       @MatrixVariable("age") Integer age,
                       @MatrixVariable("name") String name){
        HashMap<String, Object> map = new HashMap<>();
        map.put("id",id);
        map.put("age",age);
        map.put("name",name);
        return map;
    }

    @GetMapping("/boss/{id}/{newId}")
    public Map getPath2(@PathVariable("id") Integer id,
                        @PathVariable("newId") Integer newId,
                        @MatrixVariable(value = "age", pathVar = "id") Integer age,
                        @MatrixVariable(value = "age", pathVar = "newId") Integer newAge){
        HashMap<String, Object> map = new HashMap<>();
        map.put("id",id);
        map.put("newId",newId);
        map.put("age",age);
        map.put("newAge",newAge);
        return map;
    }
}
