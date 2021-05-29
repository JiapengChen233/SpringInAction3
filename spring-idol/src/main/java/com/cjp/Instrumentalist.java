package com.cjp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Instrumentalist implements Performer {
    private String song;
    @Autowired
    @Qualifier("guitar")
    private Instrument instrument;

    @Override
    public void perform() throws RuntimeException {
        System.out.println("Playing " + song + " : ");
        if (instrument != null) instrument.play();
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }
}
