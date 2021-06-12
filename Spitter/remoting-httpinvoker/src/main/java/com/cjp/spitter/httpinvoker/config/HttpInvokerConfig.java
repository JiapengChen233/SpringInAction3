package com.cjp.spitter.httpinvoker.config;

import com.cjp.spitter.service.SpitterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;

@Configuration
public class HttpInvokerConfig {

    @Bean(name = "httpInvokerSpitterService")
    public HttpInvokerServiceExporter BurlapServiceExporter(SpitterService spitterService) {
        HttpInvokerServiceExporter httpInvokerServiceExporter = new HttpInvokerServiceExporter();
        httpInvokerServiceExporter.setService(spitterService);
        httpInvokerServiceExporter.setServiceInterface(SpitterService.class);
        return httpInvokerServiceExporter;
    }
}
