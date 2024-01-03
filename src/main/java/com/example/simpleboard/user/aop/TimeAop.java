package com.example.simpleboard.user.aop;

import com.example.simpleboard.user.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class TimeAop {

    @Pointcut(value = "within(com.example.simpleboard.user.controller.UserApiController)")
    public void timerPointCut() {}

    @Around(value = "timerPointCut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("메서드 실행 이전");

        Arrays.stream(joinPoint.getArgs()).forEach(it -> {
            System.out.println(it);
            if (it instanceof UserRequest) {
                var tmpUser = (UserRequest) it;
                var phoneNumber = tmpUser.getPhoneNumber().replace("-", "");
                tmpUser.setPhoneNumber(phoneNumber);
            }
        });

        var newObjs = Arrays.asList(new UserRequest());

        joinPoint.proceed(newObjs.toArray());

        log.info("메소드 실행 이후");
    }

}
