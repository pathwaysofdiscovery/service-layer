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
    private String url;

    public LoginResponse(String userEmail, boolean authenticatied, String url) {
        this.userEmail = userEmail;
        this.authenticatied = authenticatied;
        this.url = url;

    }

    @JsonProperty
    public String getUserEmail() {
        return userEmail;
    }

    @JsonProperty
    public boolean isAuthenticatied() {
        return authenticatied;
    }

    @JsonProperty
    public String getUrl() {
        return url;
    }

}
