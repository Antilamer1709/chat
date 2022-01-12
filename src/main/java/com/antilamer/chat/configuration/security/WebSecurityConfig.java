package com.antilamer.chat.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationSuccessHandler successHandler;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().
                antMatchers(HttpMethod.OPTIONS, "/**").
                antMatchers("/").
                antMatchers("/*.{js,html}").
                antMatchers("/img/**").
                antMatchers("/fonts/**").
                antMatchers("/css/**").
                antMatchers("/404.html").
                antMatchers("/js/**").
                antMatchers("/node_modules/**").
                antMatchers("/**/*.{js,html,css}");

        web.ignoring().antMatchers("/", "/resources/**", "/index.*", "/login.html", "/favicon.ico",
                "/template/**", "/assets", "/assets/**", "/node_modules", "/node_modules/**", "/dist", "/dist/**",
                "/*.ttf", "/*.woff2", "/login", "/registration");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/api/authentication/**").permitAll()
                .antMatchers("/api/authenticate").permitAll()
                .antMatchers("/index").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/api/authenticate")
                .successHandler(successHandler)
                .usernameParameter("username").passwordParameter("password")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/api/logout")
                .deleteCookies("JSESSIONID")
                .permitAll();
        http.csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user1").password("user1").roles("USER").and()
                .withUser("user2").password("user2").roles("USER").and()
                .withUser("user3").password("user3").roles("ADMIN", "USER");
    }
}