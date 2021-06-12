package com.cjp.spitter.hessian.config;

import com.cjp.spitter.service.SpitterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;

@Configuration
public class HessianConfig {

    @Bean(name = "hessianSpitterService")
    public HessianServiceExporter hessianServiceExporter(SpitterService spitterService) {
        HessianServiceExporter hessianServiceExporter = new HessianServiceExporter();
        hessianServiceExporter.setService(spitterService);
        hessianServiceExporter.setServiceInterface(SpitterService.class);
        return hessianServiceExporter;
    }
}
