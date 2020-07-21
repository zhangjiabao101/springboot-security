package com.aaa.controller;

import com.aaa.util.SecurityUtil;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 淮南King
 * @date 2020-07-21
 */
@RestController
@RequestMapping("/resource")
public class AuthController {

    /**
     * 测试资源1
     * 拥有p1权限才可以访问
     *
     * @return
     */
    @GetMapping(value = "/r1", produces = {"text/plain;charset=UTF-8"})
    @PreAuthorize("hasAuthority('p1')")
    public String resource1() {
        //获取当前线程的SecurityContext
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //获取当前线程的名称
        return SecurityUtil.getUserNameByAuthentication(authentication) + " 访问资源1";
    }

    /**
     * 测试资源2
     * 拥有p2权限才可以访问
     *
     * @return
     */
    @GetMapping(value = "/r2", produces = {"text/plain;charset=UTF-8"})
    @PreAuthorize("hasAuthority('p2')")
    public String resource2() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return SecurityUtil.getUserNameByAuthentication(authentication) + " 访问资源2";
    }

    /**
     * 测试资源3
     * 拥有p3权限才可以访问
     *
     * @return
     */
    @GetMapping(value = "/r3", produces = {"text/plain;charset=UTF-8"})
    @PreAuthorize("hasAuthority('p3')")
    public String resource3() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return SecurityUtil.getUserNameByAuthentication(authentication) + " 访问资源3";
    }

}
