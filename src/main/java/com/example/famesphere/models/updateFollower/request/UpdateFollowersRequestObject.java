package com.example.famesphere.models.updateFollower.request;

public class UpdateFollowersRequestObject {

     private int igfollowers;

    private int ytsubscribers;

    private String igusername;

    public UpdateFollowersRequestObject() {
    }

    public UpdateFollowersRequestObject(String igusername,int igfollowers, int ytsubscribers) {
        this.igusername = igusername ;
        this.igfollowers = igfollowers;
        this.ytsubscribers = ytsubscribers;
    }

    public String getIgusername() {
        return igusername;
    }

    public void setIgusername(String igusername) {
        this.igusername = igusername;
    }

    public int getIgfollowers() {
        return igfollowers;
    }

    public void setIgfollowers(int igfollowers) {
        this.igfollowers = igfollowers;
    }

    public int getYtsubscribers() {
        return ytsubscribers;
    }

    public void setYtsubscribers(int ytsubscribers) {
        this.ytsubscribers = ytsubscribers;
    }
}
