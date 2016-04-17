package com.pods.req;

import com.google.gson.annotations.SerializedName;

/**

 {
 "user_email": "grsn.hilliard@gmail.com",
 "password": "5f4dcc3b5aa765d61d8327deb882cf99",
 "url": "/user"
 }

 */
public class AuthRequest {
    @SerializedName("user_email") private final String userEmail;
    @SerializedName("password") private final String password;
    @SerializedName("url") private final String url;

    public AuthRequest(String userEmail, String password, String url) {
        this.userEmail = userEmail;
        this.password = password;
        this.url = url;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }
}
