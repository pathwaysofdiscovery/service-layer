package com.pods.req;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jshook on 4/16/16.
 */
public class CreateUserRequest {

    @SerializedName("user_email") private final String userEmail;
    @SerializedName("password") private final String password;

    public CreateUserRequest(String userEmail, String password) {
        this.userEmail = userEmail;
        this.password = password;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getPassword() {
        return password;
    }
}
