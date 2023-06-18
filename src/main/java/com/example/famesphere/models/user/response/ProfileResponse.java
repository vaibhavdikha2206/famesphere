package com.example.famesphere.models.user.response;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "profile")
public class ProfileResponse {

    @Id
    @Column(name = "userid")
    private String userid;


    public ProfileResponse() {

    }

    public ProfileResponse(String userid,String token) {
        super();
        this.userid = userid;
    }

    public String getUserid() {
        return userid;
    }


    public void setUserid(String userid) {
        this.userid = userid;
    }

}
