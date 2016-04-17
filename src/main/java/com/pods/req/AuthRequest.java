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
    @SerializedName("username") private final String username;
    @SerializedName("password") private final String password;

    public AuthRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
