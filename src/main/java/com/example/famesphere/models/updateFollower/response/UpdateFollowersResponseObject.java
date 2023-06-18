package com.example.famesphere.models.updateFollower.response;

public class UpdateFollowersResponseObject {

    private String userid;
    private int status ;

    public UpdateFollowersResponseObject(String userid, int status) {
        this.userid = userid;
        this.status = status;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
