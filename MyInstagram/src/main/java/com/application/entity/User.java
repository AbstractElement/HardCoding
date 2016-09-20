package com.application.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Vladislav on 01.09.2016.
 */

@Entity
@Table(name = "user")
public class User implements Serializable{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "pass", length = 45)
    private String pass;

    @Basic
    @Column(name = "email", length = 45, unique = true)
    private String email;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "currentUser")
    private Profile profile;

    public void setProfile(Profile profile) {
        profile.setCurrentUser(this);
        this.profile = profile;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String password) {
        this.pass = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
