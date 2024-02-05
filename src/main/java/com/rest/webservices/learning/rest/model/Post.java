package com.rest.webservices.learning.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity(name = "post_details")
public class Post {

    @Id
    @GeneratedValue
    private Integer pid;

    private String description;


    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Post(Integer pid, String description) {
        this.pid = pid;
        this.description = description;
    }

    public Post() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "pid=" + pid +
                ", description='" + description + '\'' +
                '}';
    }
}
