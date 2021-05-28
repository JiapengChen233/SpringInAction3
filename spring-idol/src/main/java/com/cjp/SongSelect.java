package com.cjp;

public class SongSelect {

    public String selectSong(double random) {
        if ((int) (random * 10) % 2 == 0) return "Jingle Bells";
        return "Kill This In Love";
    }
}
