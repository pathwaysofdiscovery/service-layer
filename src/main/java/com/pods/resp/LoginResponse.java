package com.pods.resp;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
  {
 "user_email": "grsn.hilliard@gmail.com",
 "authenicated": "True",
 "url": "/user"
 }
 */
public class LoginResponse {

    private String userEmail;
    private boolean authenticatied;

    public LoginResponse(String userEmail, boolean authenticated) {
        this.userEmail = userEmail;
        this.authenticatied = authenticated;
    }

    @JsonProperty
    public String getUserEmail() {
        return userEmail;
    }

    @JsonProperty
    public boolean isAuthenticated() {
        return authenticatied;
    }

}
