package com.example.famesphere.models.user.request;

public class SignUpObject {

    private String userid;
    private String password;
    private String signkey;

    private String email;

    /*private int igfollowers;

    private int ytsubscribers;*/

    public SignUpObject() {

    }

    public SignUpObject(String userid, String password, String signkey, String email
            //,int igfollowers,int ytsubscribers
    ) {
        super();
        this.userid = userid;
        this.password = password;
        this.signkey = signkey;
        this.email = email;
        //this.igfollowers = igfollowers;
        //this.ytsubscribers = ytsubscribers;
    }

    public String getUserid() {
        return userid;
    }

    public String getPassword() {
        return password;
    }

    public String getSignkey() {
        return signkey;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSignkey(String signkey) {
        this.signkey = signkey;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*public int getIgfollowers() {
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
    }*/
}
