package com.aaa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * spring security配置
 *
 * @author 淮南King
 */
@Configuration @EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfig
    extends WebSecurityConfigurerAdapter {

    //密码编码器
    @Bean public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //安全拦截机制

    @Override protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
            //所有/r/**的请求必须认证通过
            .antMatchers("/r/**").authenticated()
            //除了/r/**，其它的请求可以访问
            .anyRequest().permitAll()
            .and()
            //允许表单登录
            .formLogin()
            //登录页面路径
            .loginPage("/login-view")
            .loginProcessingUrl("/login")
            //自定义登录成功的页面地址
            .successForwardUrl("/login-success")
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
            .and()
            .logout()
            //登录退出
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login-view?logout");
    }
}
