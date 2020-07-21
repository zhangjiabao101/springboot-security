package com.aaa.controller;

import com.aaa.entity.UserDto;
import com.aaa.service.UserService;
import com.aaa.util.SecurityUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 淮南King
 */
@RestController
public class LoginController {

    @Resource private UserService service;

    @RequestMapping(value = "/login-success",produces = {"text/plain;charset=UTF-8"})
    public ModelAndView loginSuccess(){
        //获取当前线程的SecurityContext
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //获取当前线程中用户的名称,将名称传递至页面
        Map<String,Object> attributes = new HashMap<>();
        attributes.put("username",SecurityUtil.getUserNameByAuthentication(authentication));
        return new ModelAndView("menu",attributes);
    }

    @PostMapping("/user/register")
    public String register(UserDto userDto) {
        service.addUser(userDto);
        return userDto.getUsername()+"注册成功";
    }
    @GetMapping("/register")
    public ModelAndView registerView() {
        return new ModelAndView("register");
    }

}
