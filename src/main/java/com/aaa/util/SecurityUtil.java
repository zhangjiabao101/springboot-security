package com.aaa.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Security帮助类
 * @author 淮南King
 * @date 2020-07-21
 */
public class SecurityUtil {

    /**
     * 根据当前执行线程的SecurityContext获取用户名称
     * @param authentication 当前认证通过的用户身份
     * @return 用户名
     */
    public static String getUserNameByAuthentication(Authentication authentication){
        String username = null;
        //用户身份
        Object principal = authentication.getPrincipal();
        if(principal == null){
            return "匿名";
        }
        if(principal instanceof UserDetails){
            UserDetails userDetails = (UserDetails)principal;
            username = userDetails.getUsername();
        }else{
            username = principal.toString();
        }
        return username;
    }
}
