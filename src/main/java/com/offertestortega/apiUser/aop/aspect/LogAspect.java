package com.offertestortega.apiUser.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    @Pointcut("execution (public * com.offertestortega.apiUser.service.*Service.*(..))")
    public void methodCall() {}

    @Before("methodCall()")
    public void log(JoinPoint joinPoint) {
        System.out.printf("Appel de %s avec %d paramètres%n",
                joinPoint.toShortString(),
                joinPoint.getArgs().length);
    }

    @AfterThrowing(pointcut = "methodCall()", throwing = "e")
    public void log(JoinPoint joinPoint, Throwable e) {
        System.out.printf("Retour de %s avec une exception %s%n",
                joinPoint.toShortString(),
                e.getClass().getSimpleName());
    }
}
