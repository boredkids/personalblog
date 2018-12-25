package pers.zhao.personalblog.bloggateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 主页，登录页，注册页跳转
 * @author zhao
 * @date 2018/12/24 10:11
 */
@Controller
public class SysController {

    @GetMapping("/")
    public String root(){
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
