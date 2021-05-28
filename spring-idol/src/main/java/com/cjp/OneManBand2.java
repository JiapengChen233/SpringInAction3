package com.cjp;

import java.util.Map;

public class OneManBand2 implements Performer {
    private Map<String, Instrument> instruments;

    @Override
    public void perform() throws RuntimeException {
        for (String key : instruments.keySet()) {
            System.out.print(key + " : ");
            Instrument instrument = instruments.get(key);
            instrument.play();
        }
    }

    public Map<String, Instrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(Map<String, Instrument> instruments) {
        this.instruments = instruments;
    }
}