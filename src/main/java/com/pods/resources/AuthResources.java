package com.pods.resources;

import com.codahale.metrics.annotation.Timed;
import com.datastax.driver.mapping.Mapper;
import com.google.gson.Gson;
import com.pods.models.User;
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

    private final Mapper<User> userMapper;

    public AuthResources(Mapper<User> userMapper) {
        this.userMapper = userMapper;
    }

    @POST
    @Path("/login")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @Timed
    public LoginResponse getResponse(
            String req) {
        Gson gson = new Gson();
        AuthRequest request = gson.fromJson(req, AuthRequest.class);

        User user = userMapper.get(request.getUsername());

        return new LoginResponse(
                request.getUsername(),
                request.getPassword().equals(user.getPassword())
        );
    }

}
