package top.mowang.springboot2_project.expection;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * SpringBoot2-quick-start
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/15 21:52
 **/
@ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "用户数量太多")
public class UserTooManyException extends RuntimeException{
    public UserTooManyException() {
    }

    public UserTooManyException(String message) {
        super(message);
    }
}
