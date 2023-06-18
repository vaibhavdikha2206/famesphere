package com.example.famesphere.models.updateFollower.request;

public class UpdateFollowersRequestObject {

     private int igfollowers;

    private int ytsubscribers;

    public UpdateFollowersRequestObject() {
    }

    public UpdateFollowersRequestObject(int igfollowers, int ytsubscribers) {
        this.igfollowers = igfollowers;
        this.ytsubscribers = ytsubscribers;
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
