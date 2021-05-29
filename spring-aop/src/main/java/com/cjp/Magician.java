package com.cjp;

import org.aspectj.lang.annotation.*;

@Aspect
public class Magician implements MindReader {
    private String thoughts;

    @Pointcut("execution(* com.cjp.Thinker.thinkOfSomething(String)) && args(thoughts)")
    public void thinking(String thoughts) {
    }

    @Before("thinking(thoughts)")
    @Override
    public void interceptThoughts(String thoughts) {
        System.out.println("Intercepting volunteer's thoughts");
        this.thoughts = thoughts;
    }

    @Override
    public String getThoughts() {
        return thoughts;
    }
}
