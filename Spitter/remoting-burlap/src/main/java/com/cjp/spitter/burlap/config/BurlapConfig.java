package com.cjp.spitter.burlap.config;

import com.cjp.spitter.service.SpitterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.BurlapServiceExporter;

@Configuration
public class BurlapConfig {

    @Bean(name = "burlapSpitterService")
    public BurlapServiceExporter BurlapServiceExporter(SpitterService spitterService) {
        BurlapServiceExporter burlapServiceExporter = new BurlapServiceExporter();
        burlapServiceExporter.setService(spitterService);
        burlapServiceExporter.setServiceInterface(SpitterService.class);
        return burlapServiceExporter;
    }
}
