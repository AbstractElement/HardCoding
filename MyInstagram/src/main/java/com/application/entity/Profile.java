package com.application.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "profile")
public class Profile implements Serializable {
    @Id
    @Column(name = "idProfile")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProfile;

    @Basic
    @Column(name = "firstName", length = 45)
    private String firstName = "";

    @Basic
    @Column(name = "lastName", length = 45)
    private String lastName = "";

    @Basic
    @Column(name = "currentCity", length = 45)
    private String currentCity = "";

    @Basic
    @Column(name = "phoneNumber", length = 45)
    private String phoneNumber = "";

    @Basic
    @Column(name = "age")
    private int age = 0;

    @Basic
    @Column(name = "sex")
    private String sex = "other.png";

    @Basic
    @Column(name = "avatar")
    private String avatar = "1.jpg";

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idUser")
    private User currentUser;

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, mappedBy = "profile")
    private List<Posts> posts = new ArrayList<Posts>();

//    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "ownerLike")
//    private List<Likes> likes = new ArrayList<Likes>();
//
//    public List<Likes> getLikes() {
//        return likes;
//    }
//
//    public void setLikes(List<Likes> likes) {
//        this.likes = likes;
//    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<Posts> getPosts() {
        return posts;
    }

    public void setPosts(List<Posts> posts) {
        this.posts = posts;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(int idProfile) {
        this.idProfile = idProfile;
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
