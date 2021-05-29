package com.cjp.config;

import com.cjp.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringIdolConfig {

    @Value("#{settings['song.name']}")
    private String songName;

    @Bean
    public Performer performer() {
        Instrumentalist performer = new Instrumentalist();
        performer.setSong(songName);
        performer.setInstrument(guitar());
        return performer;
    }

    @Bean
    public Instrument guitar() {
        return new Guitar();
    }
}
