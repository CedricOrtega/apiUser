package com.offertestortega.apiUser.aop.aspect;

import com.offertestortega.apiUser.aop.annotation.Supervision;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

public class SupervisionAspect {
    @Around("@annotation(supervision)")
    public Object superviser(ProceedingJoinPoint joinPoint, Supervision supervision)
            throws Throwable {
        long start = System.currentTimeMillis();
        try {
            return joinPoint.proceed(joinPoint.getArgs());
        } finally {
            long end = System.currentTimeMillis();
            long duree = end - start;
                System.out.printf("Attention l'appel à %s à durée%n",
                        joinPoint.toShortString(), duree);
        }
    }
}
