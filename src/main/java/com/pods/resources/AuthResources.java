package com.pods.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.gson.Gson;
import com.pods.req.AuthRequest;
import com.pods.resp.LoginResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by jshook on 4/16/16.
 */

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
public class AuthResources {

    @POST
    @Path("/login")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @Timed
    public LoginResponse getResponse(
            String req) {
        Gson gson = new Gson();
        AuthRequest request = gson.fromJson(req,AuthRequest.class);

        if (request.getUserEmail().equals("good@example.com")) {
            return new LoginResponse(request.getUserEmail(), true, "/api/login");
        }
        else {
            return new LoginResponse(request.getUserEmail(),false,"/api/login");
        }
    }

}
