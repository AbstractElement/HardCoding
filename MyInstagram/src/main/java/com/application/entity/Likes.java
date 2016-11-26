package com.application.entity;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "likes")
public class Likes {
    @Id
    @Column(name = "idLike")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLike;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "idProfile")
    private Profile ownerLike;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "idPost")
    private Posts idPosts;

    @Column(name = "timeThisLike")
    private Date timeThisLike;

    public String getTimeThisLike() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy ':' HH:mm");
        return dateFormat.format(timeThisLike);
    }

    public void setTimeThisLike(Date timeThisLike) {
        this.timeThisLike = timeThisLike;
    }

    public Profile getOwnerLike() {
        return ownerLike;
    }

    public void setOwnerLike(Profile ownerLike) {
        this.ownerLike = ownerLike;
    }

    public int getIdLike() {
        return idLike;
    }

    public void setIdLike(int idLike) {
        this.idLike = idLike;
    }

    public Posts getIdPosts() {
        return idPosts;
    }

    public void setIdPosts(Posts idPosts) {
        this.idPosts = idPosts;
    }
}
