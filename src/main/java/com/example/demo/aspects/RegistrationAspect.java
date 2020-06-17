package com.example.demo.aspects;

import com.example.demo.dto.SignUpDto;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class RegistrationAspect {

    private final Logger log = LoggerFactory.getLogger(RegistrationAspect.class);

    @After(value = "execution(* com.example.demo.controllers.SignUpController.getSignUpPage(*))")
    public void getPage(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        SignUpDto user = (SignUpDto) args[0];
        log.info("Пользователь хочет зарегестрироваться");
    }

    @Before(value = "execution(* com.example.demo.controllers.SignUpController.signUp(*))")
    public void before(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        SignUpDto user = (SignUpDto) args[0];
        log.info("Пользователь - " + user + " начал регистрацию");
    }

    @AfterReturning(value = "execution(* com.example.demo.controllers.SignUpController.signUp(*))")
    public void after(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        SignUpDto user = (SignUpDto) args[0];
        log.info("Пользователь - " + user + " завершил регистрацию");
    }

}
