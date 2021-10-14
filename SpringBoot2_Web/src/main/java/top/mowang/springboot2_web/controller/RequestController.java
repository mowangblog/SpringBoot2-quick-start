package top.mowang.springboot2_web.controller;

import org.apache.logging.log4j.message.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * SpringBoot2-quick-start
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/14 17:42
 **/
@Controller
public class RequestController {

    @RequestMapping("/getPage")
    public String getPage(HttpServletRequest httpServletRequest){
        httpServletRequest.setAttribute("code",200);
        httpServletRequest.setAttribute("msg","成功");
        return "forward:success";
    }

    @ResponseBody
    @RequestMapping("/success")
    public Map success(@RequestAttribute("msg") String message,
                       @RequestAttribute("code") Integer code,
                       HttpServletRequest httpServletRequest){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg",message);
        map.put("code",code);
        map.put("httpServletRequest_msg",httpServletRequest.getAttribute("msg"));
        map.put("httpServletRequest_code",httpServletRequest.getAttribute("code"));
        return map;
    }


}
