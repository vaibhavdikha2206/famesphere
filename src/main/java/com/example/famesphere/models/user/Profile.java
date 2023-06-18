package com.example.famesphere.models.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Profile {
    @Id
    @Column(name = "userid")
    private String userid;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "instafollower")
    private Integer instafollower;

    @Column(name = "ytsubscribers")
    private Integer ytsubscribers;

    public Profile() {

    }

    public Profile(String userid, String password,String email,Integer instafollower, Integer ytsubscribers) {
        super();
        this.userid = userid;
        this.password = password;
        this.email = email;
        this.instafollower = instafollower;
        this.ytsubscribers = ytsubscribers;
    }

    public String getUserid() {
        return userid;
    }

    public String getPassword() {
        return password;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public Integer getInstafollower() {
        return instafollower;
    }

    public Integer getYtsubscribers() {
        return ytsubscribers;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setInstafollower(Integer instafollower) {
        this.instafollower = instafollower;
    }

    public void setYtsubscribers(Integer ytsubscribers) {
        this.ytsubscribers = ytsubscribers;
    }
}
