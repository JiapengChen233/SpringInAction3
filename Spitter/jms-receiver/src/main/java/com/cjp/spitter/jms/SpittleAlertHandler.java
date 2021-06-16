package com.cjp.spitter.jms;

import com.cjp.spitter.domain.Spittle;

public class SpittleAlertHandler {
    public void processSpittle(Spittle spittle) {
        System.out.println(spittle);
    }
}
