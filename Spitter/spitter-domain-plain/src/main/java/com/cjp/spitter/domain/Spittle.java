package com.cjp.spitter.domain;

import java.io.Serializable;
import java.util.Date;

public class Spittle implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Spitter spitter;
    private String text;
    private Date postedTime;

    public Spittle() {
        this.spitter = new Spitter();
        this.spitter.setId(1L);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Spitter getSpitter() {
        return spitter;
    }

    public void setSpitter(Spitter spitter) {
        this.spitter = spitter;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getPostedTime() {
        return postedTime;
    }

    public void setPostedTime(Date postedTime) {
        this.postedTime = postedTime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Spittle{");
        sb.append("id=").append(id);
        sb.append(", spitter=").append(spitter);
        sb.append(", text='").append(text).append('\'');
        sb.append(", postedTime=").append(postedTime);
        sb.append('}');
        return sb.toString();
    }
}
