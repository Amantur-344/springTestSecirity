package com.example24.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("{noop}qwert").roles("ADMIN").and()
                .withUser("user").password("{noop}1234").roles("USER").and()
                .withUser("user2").password("{noop}5678").roles("USER").and()
                .withUser("moderator").password("{noop}password").roles("MODERATOR").and()
                .withUser("moderator2").password("{noop}dsaqwer").roles("MODERATOR");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.GET,"/api/task").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/api/task").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/api/task").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/api/task").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/task").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/api/task").hasRole("MODERATOR")
                .antMatchers(HttpMethod.PUT, "/api/task").hasRole("MODERATOR")
                .antMatchers(HttpMethod.GET,"/api/check-user").hasRole("USER")
                .and().csrf().disable();
    }
}
