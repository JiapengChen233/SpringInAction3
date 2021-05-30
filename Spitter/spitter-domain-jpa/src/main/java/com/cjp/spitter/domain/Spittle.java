package com.cjp.spitter.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "spittle")
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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "spitter_id")
    public Spitter getSpitter() {
        return spitter;
    }

    public void setSpitter(Spitter spitter) {
        this.spitter = spitter;
    }

    @Column(name = "text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Column(name = "posted_time")
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
