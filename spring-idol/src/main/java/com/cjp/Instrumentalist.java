package com.cjp;

public class Instrumentalist implements Performer {
    private String song;
    
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
