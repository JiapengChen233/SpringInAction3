package com.cjp.spitter.jms;

import com.cjp.spitter.domain.Spittle;

public interface AlertService {
    void sendSpittleAlert(Spittle spittle);
}
