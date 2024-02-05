package com.rest.webservices.learning.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity(name="user_details")
public class User {

    @Id
    @GeneratedValue
    private Integer uid;
    private String uname;
    private LocalDate dob;

    @OneToMany(mappedBy = "user")
   // @JsonIgnore
    private List<Post> post;

    public User(Integer uid, String uname, LocalDate dob) {
        this.uid = uid;
        this.uname = uname;
        this.dob = dob;
    }

//    public User(Integer uid, String uname, LocalDate dob, List<Post> post) {
//        this.uid = uid;
//        this.uname = uname;
//        this.dob = dob;
//        this.post = post;
//    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public User() {
    }

    public List<Post> getPost() {
        return post;
    }

    public void setPost(List<Post> post) {
        this.post = post;
    }


    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", dob=" + dob +
                ", post=" + post +
                '}';
    }
}
