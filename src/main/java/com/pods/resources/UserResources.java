package com.pods.resources;

import com.codahale.metrics.annotation.Timed;
import com.datastax.driver.mapping.Mapper;
import com.google.gson.Gson;
import com.pods.models.User;
import com.pods.req.AuthRequest;
import com.pods.req.CreateUserRequest;
import com.pods.resp.LoginResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by jshook on 4/16/16.
 */

@Path("/api/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResources {

    private final Mapper<User> userMapper;

    public UserResources(Mapper<User> userMapper) {
        this.userMapper = userMapper;
    }

    @POST
    @Path("/create")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @Timed
    public CreateUserResponse createUser(String req) {
        Gson gson = new Gson();
        CreateUserRequest request = gson.fromJson(req,CreateUserRequest.class);

        try {
            userMapper.save(new User(request.getUserEmail(),request.getPassword()));
        } catch (Exception e) {

            e.printStackTrace();
        }

        User user = userMapper.get(request.getUserEmail());

        return new LoginResponse(
                request.getUserEmail(),
                user.getPassword().equals(request.getPassword())
        );
    }

}
