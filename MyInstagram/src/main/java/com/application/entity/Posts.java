package com.application.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "posts")
public class Posts {
    @Id
    @Column(name = "idPost")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPosts;

    @Column(name = "message")
    private String message;

    @Column(name = "timeOfPublication")
    private Date timeOfPublication;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "idProfile")
    private Profile profile;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "idPosts")
    private List<Likes> likes = new ArrayList<Likes>();

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public int getIdPosts() {
        return idPosts;
    }

    public void setIdPosts(int idPosts) {
        this.idPosts = idPosts;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimeOfPublication() {
        return timeOfPublication;
    }

    public void setTimeOfPublication(Date timeOfPublication) {
        this.timeOfPublication = timeOfPublication;
    }
}
