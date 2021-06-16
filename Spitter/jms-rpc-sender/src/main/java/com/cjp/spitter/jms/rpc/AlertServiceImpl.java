package com.cjp.spitter.jms.rpc;

public class AlertServiceImpl implements AlertService {

    @Override
    public void sendAlert() {
        System.out.println("调用服务");
    }
}
