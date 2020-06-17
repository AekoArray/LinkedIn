package com.example.demo.aspects;

import com.example.demo.dto.SignUpDto;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthAspect {
    private final Logger log = LoggerFactory.getLogger(RegistrationAspect.class);

    @After(value = "execution(* com.example.demo.controllers.SignInController.getSignInPage(*))")
    public void getPage(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        SignUpDto user = (SignUpDto) args[0];
        log.info("Пользователь"+ user + "- открыл страницу авторизации");
    }
}
