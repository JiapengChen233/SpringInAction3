package com.cjp;

public class PoeticJuggler extends Juggler {
    private final Poem poem;

    public PoeticJuggler(Poem poem) {
        this.poem = poem;
    }

    public PoeticJuggler(int beanBags, Poem poem) {
        super(beanBags);
        this.poem = poem;
    }

    @Override
    public void perform() throws RuntimeException {
        super.perform();
        System.out.println("While reciting...");
        poem.recite();
    }
}
