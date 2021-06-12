package com.cjp.spitter.rmi.config;

import com.cjp.spitter.service.SpitterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

@Configuration
public class RmiConfig {

    /**
     * 默认情况下，RmiServiceExporter会尝试将一个RMI注册表绑定到本地机器的1099端口。如果在这个端口没有发现RMI注册表，
     * RmiServiceExporter将重新启动一个注册表。如果希望将某个RMI注册表绑定到不同的端口或主机，可以通过registryPort和
     * registryHost属性来指定。
     */
    @Bean
    public RmiServiceExporter rmiServiceExporter(SpitterService spitterService) {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setService(spitterService);
        rmiServiceExporter.setServiceName("SpitterService");
        rmiServiceExporter.setServiceInterface(SpitterService.class);
        return rmiServiceExporter;
    }
}
