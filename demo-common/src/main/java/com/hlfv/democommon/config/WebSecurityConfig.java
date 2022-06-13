package com.hlfv.democommon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserDetailsService userDetailsService;
    @Resource
    private RestAuthenticationSuccessHandler successHandler;
    @Resource
    private JwtAccessDeniedHandler accessDeniedHandler;
    @Resource
    private JwtAuthenticationEntryPoint authenticationEntryPoint;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /**
         * 2. 第二种方式：通过配置类的方式进行配置
         */
        // PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        // String password = passwordEncoder.encode("123456");
        // List<GrantedAuthority> authorities = new ArrayList<>();
        // auth.inMemoryAuthentication().withUser("admin").password(password).authorities(authorities);
        /**
         * 3. 第三种方式：通过自定义UserDetailsService从数据库进行加载
         */
         auth.userDetailsService(userDetailsService)
                 .passwordEncoder(passwordEncoder());
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                // .addFilterBefore(new SessionFilter(), UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                // .loginProcessingUrl("/account/login")
                .successHandler(successHandler)
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .accessDeniedHandler(accessDeniedHandler)
                // 防止iframe 造成跨域
                .and()
                .headers()
                .frameOptions()
                .disable()
                // 不创建会话
                .and()
                .sessionManagement()
                // 设置Session失效跳转页面
                .invalidSessionUrl("/login.html")
                // 设置最大Session数为1
                .maximumSessions(1)
                // 设置Session过期处理策略
                .expiredSessionStrategy(new SessionInformationExpiredStrategyImpl())
                .and()
                .and().authorizeRequests()
                // 所有请求都需要认证
                .anyRequest().authenticated()
                .and()
                .logout();
    }
}
