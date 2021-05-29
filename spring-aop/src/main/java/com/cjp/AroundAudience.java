package com.cjp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class AroundAudience {

    @Around("com.cjp.Audience.performance()")
    public void watchPerformance(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("The audience is taking their seats.");
            System.out.println("The audience is turning off their cellphones");
            long start = System.currentTimeMillis();
            joinPoint.proceed();
            long end = System.currentTimeMillis();
            System.out.println("CLAP CLAP CLAP CLAP");
            System.out.println("The performance took " + (end - start) + " milliseconds.");
        } catch (Throwable t) {
            System.out.println("Boo! We want our money back!");
        }
    }
}
