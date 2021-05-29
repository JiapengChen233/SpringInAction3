package com.cjp;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class ContestantIntroducer {

    @DeclareParents(value = "com.cjp.Performer+", defaultImpl = GraciousContestant.class)
    public static Contestant contestant;
}
