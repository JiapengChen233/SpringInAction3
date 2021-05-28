package com.cjp;

import java.util.Collection;

public class OneManBand implements Performer {
    private Collection<Instrument> instruments;

    @Override
    public void perform() throws RuntimeException {
        for (Instrument instrument : instruments) {
            instrument.play();
        }
    }

    public Collection<Instrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(Collection<Instrument> instruments) {
        this.instruments = instruments;
    }
}
