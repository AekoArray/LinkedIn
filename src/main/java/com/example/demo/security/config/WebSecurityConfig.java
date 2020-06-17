package com.example.demo.security.config;

import com.example.demo.security.detailss.AuthProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@EnableWebSecurity
@EnableOAuth2Client
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthProviderImpl authProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/signup", "/signIn").anonymous()
                .antMatchers("/users", "/profile", "/company/{id}/createNewVacancy", "/addPost", "/chat", "user/{id_user}/skill/{id_skill}/assessment").authenticated()
                .antMatchers("/static/**").permitAll()
                .antMatchers("/users").hasAuthority("ADMIN")
                .and().csrf().disable()

                .formLogin()
                .loginPage("/signIn")
                .loginProcessingUrl("/signIn/process")
                .usernameParameter("email")
                .failureUrl("/signIn?error=true")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/profile")
                .and().logout();


    }

    @Autowired
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
    }

}
