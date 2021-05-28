package com.cjp;

import java.util.Map;
import java.util.Properties;

public class OneManBand3 implements Performer {
    private Properties instruments;

    @Override
    public void perform() throws RuntimeException {
        for (Map.Entry entry : instruments.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public Properties getInstruments() {
        return instruments;
    }

    public void setInstruments(Properties instruments) {
        this.instruments = instruments;
    }
}
