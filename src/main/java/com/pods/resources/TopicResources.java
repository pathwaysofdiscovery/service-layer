package com.pods.resources;

import com.codahale.metrics.annotation.Timed;
import com.datastax.driver.core.utils.UUIDs;
import com.datastax.driver.mapping.Mapper;
import com.google.gson.Gson;
import com.pods.db.TopicDao;
import com.pods.models.Topic;
import com.pods.req.CreateTopicRequest;
import com.pods.req.SearchTopicsRequest;
import com.pods.resp.CreateTopicResponse;
import com.pods.resp.SearchTopicsResponse;
import com.pods.resp.TopicResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.UUID;
import java.util.stream.Collectors;

@Path("/api/")
@Produces(MediaType.APPLICATION_JSON)
public class TopicResources {

    private final Mapper<Topic> topicMapper;
    private final TopicDao topicDao;

    public TopicResources(Mapper<Topic> userMapper, TopicDao topicDao) {
        this.topicMapper = userMapper;
        this.topicDao = topicDao;
    }

    @POST
    @Path("/topic/create")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @Timed
    public CreateTopicResponse createTopic(String req) {
        Gson gson = new Gson();
        CreateTopicRequest request = gson.fromJson(req,CreateTopicRequest.class);

        UUID uuid = UUIDs.timeBased();

        topicMapper.save(new Topic(request.getName(),request.getDescription(),uuid,request.getImageUrl()));
        return new CreateTopicResponse(request.getName(),request.getDescription(),request.getImageUrl(),uuid);
    }

    @POST
    @Path("/topics/search")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @Timed
    public SearchTopicsResponse searchTopics(String req) {
        Gson gson = new Gson();
        SearchTopicsRequest request = gson.fromJson(req,SearchTopicsRequest.class);

        ArrayList<Topic> matchingTopics = topicDao.getAllTopics()
                .stream()
                .filter(t -> t.getTopicName().matches(request.getSearchPattern()))
                .filter(t -> t.getDescription().matches(request.getSearchPattern()))
                .collect(Collectors.toCollection(ArrayList::new));

        return new SearchTopicsResponse(matchingTopics);
    }

    @GET
    @Path("/topic/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @Timed
    public TopicResponse getTopic(@PathParam("id") String uuid) {
        Topic topic = topicMapper.get(UUID.fromString(uuid));
        return new TopicResponse(topic);
    }

}
