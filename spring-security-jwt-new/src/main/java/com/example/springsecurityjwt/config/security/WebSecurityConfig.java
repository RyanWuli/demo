package com.example.springsecurityjwt.config.security;

import com.example.springsecurityjwt.config.filter.JwtAuthTokenFilter;
import com.example.springsecurityjwt.config.security.handler.MyAuthenticationFailureHandler;
import com.example.springsecurityjwt.config.security.handler.MyAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/**
 * @Author: Ryan
 * @Date: 2020/10/31 18:19
 * @Version: 1.0
 * @Description:
 */
//@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private MyAuthenticationSuccessHandler successHandler;

    @Resource
    private MyAuthenticationFailureHandler failureHandler;

    @Resource
    UserDetailsService userDetailsService;

    @Resource
    JwtAuthTokenFilter jwtAuthTokenFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // formLogin
//        http.formLogin() // 开启 formLogin 模式
//                .loginPage("/login.html") // 用户未登录时，访问任何资源都跳到该路径
//                .loginProcessingUrl("/login") // 登录表单中 action 的地址，也就是处理认证的请求路径
//                .usernameParameter("username") // 用户名参数名称，默认 username
//                .passwordParameter("password") // 密码参数名称，默认 password
////                .defaultSuccessUrl("/index") // 登录成功跳转页面
////                .failureUrl("/login.html") // 登录失败跳转页面
//                .successHandler(successHandler) // 登录成功返回处理结果
//                .failureHandler(failureHandler) // 登录失败返回处理结果
//                .and() // 使用 and 连接
//            .authorizeRequests() // 权限配置
//                .antMatchers("/login.html", "/login")
//                .permitAll() // 用户可任意访问
//                .antMatchers("/order") // 需要对外暴露的资源
//                .hasAnyAuthority("ROLE_user", "ROLE_admin") // user 角色和 admin 角色都可以访问
//                .antMatchers("/system/user", "/system/role", "/system/menu")
//                .hasAnyRole("admin") // admin 角色可以访问
//                .anyRequest().authenticated() // 其它所有需要鉴权认证，authenticated()要求在执行该请求时，必须已经登录了应用
//                .and()
//                .csrf().disable(); // 禁用跨站 csrf 攻击防御，否则无法登录成功
//        http.logout().logoutUrl("/logout"); // 退出功能

        // jwt
        http
                // 认证失败处理类
                //.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                // 基于token，所以不需要session,这里设置STATELESS(无状态)是在请求是不生成session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                //配置权限
                .authorizeRequests()
                //对于登录login  验证码captchaImage  允许匿名访问
                .antMatchers("/login").anonymous()
                .antMatchers(
                        HttpMethod.GET,
                        "/*.html",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js"
                ).permitAll()
                .antMatchers("/order")  //需要对外暴露的资源路径
                .hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")    //user角色和 admin角色都可以访问
                .antMatchers("/system/user", "/system/role", "/system/menu")
                .hasAnyRole("ADMIN")    //admin角色可以访问
                //  除上面外的所有请求全部需要鉴权认证
                .anyRequest().authenticated().and()//authenticated()要求在执 行该请求时，必须已经登录了应用
                //  CRSF禁用，因为不使用session
                .csrf().disable();//禁用跨站csrf攻击防御，否则无法登陆成功
        //登出功能
        http.logout().logoutUrl("/logout");
        //  添加JWT  filter, 在每次http请求前进行拦截
        http.addFilterBefore(jwtAuthTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

    // 数据库做登录

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }


    // 内存做的登录
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user")
//                .password(bCryptPasswordEncoder().encode("123456"))
//                .roles("user")
//                .and()
//                .withUser("admin")
//                .password(bCryptPasswordEncoder().encode("1234567"))
//                .roles("admin")
//                .and()
//                .passwordEncoder(bCryptPasswordEncoder()); // 配置 BCrypt 加密
//    }

    /**
     * 强散列哈希加密实现
     * @return
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 注入 AuthenticationManager
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
