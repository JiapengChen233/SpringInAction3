package com.cjp;

public class Artist implements Performer {

    private String name = "Ronaldo";

    @Override
    public void perform() throws RuntimeException {
        System.out.println(name + " is playing...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
