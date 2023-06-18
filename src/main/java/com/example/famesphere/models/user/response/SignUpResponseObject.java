package com.example.famesphere.models.user.response;

import com.example.famesphere.models.user.Profile;

public class SignUpResponseObject {
    Profile profile ;
    String token ;

    public SignUpResponseObject(Profile profile, String token) {
        this.profile = profile;
        this.token = token;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
