package com.aaa.service;

import com.aaa.dao.UserDao;
import com.aaa.entity.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 实现spring-security核心接口，其负载的用户特定数据。
 *
 * @author 淮南King
 */
@Service
public class SpringDataUserDetailsService implements UserDetailsService {

    @Autowired
    UserDao userDao;

    // 根据账号查询用户信息
    @Override public UserDetails loadUserByUsername(String username) {
        //将来连接数据库根据账号查询用户信息
        UserDto userDto = userDao.getUserByUsername(username);
        //当查询此用户不存在时，将抛出用户名未找到异常
        if (userDto == null) {
            throw new UsernameNotFoundException("No such user found, the user name is: "+username);
        }
        //根据用户id查询权限
        List<String> permissions = userDao.findPermissionsByUserId(userDto.getId());
        //将permissions转为数组
        String[] permissionArray = new String[permissions.size()];
        permissions.toArray(permissionArray);
        UserDetails userDetails =
            User.withUsername(userDto.getUsername()).password(userDto.getPassword()).authorities(permissionArray)
                .build();
        return userDetails;
    }
}
