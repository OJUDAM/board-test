package com.jpa.factory.common.config;

import com.jpa.factory.common.component.CustomAuthenticationProvider;
import com.jpa.factory.handler.LoginFailureHandler;
import com.jpa.factory.handler.LoginSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * packageName    : com.jpa.factory.common.config
 * fileName       : SecurityConfig
 * author         : 오주담
 * date           : 2022-12-20
 * description    : 스프링 시큐리티 설정
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-12-20        오주담       최초 생성
 */

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/fonts/**", "/img/**", "/images/**", "/js/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests() //url 권한 설정
                .antMatchers("/login").permitAll()
                .antMatchers("/logout").permitAll()
                .antMatchers("/login/**").permitAll()
                .antMatchers("/admin/**").hasRole("WEBMASTER")
                .antMatchers("**").hasAnyRole("MEMBER")
                .and()
                .formLogin() // 로그인설정
                .loginPage("/login").permitAll()
                .loginProcessingUrl("/login/process").permitAll()
                .usernameParameter("userId")
                .passwordParameter("userPwd")
                .successHandler(new LoginSuccessHandler())
                .failureHandler(new LoginFailureHandler())
                .and()//로그아웃 설정
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true);

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        return new CustomAuthenticationProvider();
    }
}
