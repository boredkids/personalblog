package pers.zhao.personalblog.bloggateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pers.zhao.personalblog.blogdomain.domain.Category;
import pers.zhao.personalblog.bloggateway.service.CategoryService;

import java.util.List;

/**
 * 主页，登录页，注册页跳转
 * @author zhao
 * @date 2018/12/24 10:11
 */
@Controller
public class SysController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public String root(){
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index(Model model){
        List<Category> categories = categoryService.selectAll();
        model.addAttribute(categories);
        return "index";
    }
}
