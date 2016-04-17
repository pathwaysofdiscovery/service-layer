package com.pods.resources;

import com.codahale.metrics.annotation.Timed;
import com.datastax.driver.core.utils.UUIDs;
import com.datastax.driver.mapping.Mapper;
import com.google.gson.Gson;
import com.pods.db.NodeDao;
import com.pods.models.Node;
import com.pods.models.NodeByTopic;
import com.pods.req.ConnectPrereqNodeRequest;
import com.pods.req.CreateNodeRequest;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Path("/api")
public class NodeResources {
    private final Mapper<Node> nodeMapper;
    private final Mapper<NodeByTopic> nodeByTopicMapper;
    private final NodeDao nodeDao;

    @Context
    UriInfo uriInfo;

    public NodeResources(
            Mapper<Node> nodeMapper,
            Mapper<NodeByTopic> nodeByTopicMapper,
            NodeDao nodeDao) {
        this.nodeMapper = nodeMapper;
        this.nodeByTopicMapper = nodeByTopicMapper;
        this.nodeDao = nodeDao;
    }

    @POST
    @Path("/nodes/create")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @Timed
    public NodeResponse createNode(String req) {
        Gson gson = new Gson();
        CreateNodeRequest request = gson.fromJson(req,CreateNodeRequest.class);

        UUID uuid = UUIDs.timeBased();

        HashSet<UUID> prereqs = request.getPrereqs()
                .stream()
                .map(UUID::fromString)
                .collect(Collectors.toCollection(HashSet::new));

        HashSet<UUID> leadsto = request.getLeadsTo()
                .stream()
                .map(UUID::fromString)
                .collect(Collectors.toCollection(HashSet::new));

        Node node = new Node(
                uuid,
                UUID.fromString(request.getTopicId()),
                request.getDescription(),
                request.getTopicName(),
                request.getRating(),
                prereqs,leadsto);

        nodeMapper.save(node);
        nodeByTopicMapper.save(new NodeByTopic(node));

        return new NodeResponse(node,uriInfo.getBaseUri()+"api/node/" + uuid);

    }

    @GET
    @Path("/nodes/bytopic/{topic_id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @Timed
    public NodesResponse getNodesByTopic(@PathParam("topic_id") String topicId) {
        List<Node> nodesByTopic = nodeDao.getNodesByTopic(UUID.fromString(topicId));
        ArrayList<NodeResponse> nodeResponses = nodesByTopic
                .stream()
                .map(n -> new NodeResponse(n, uriInfo.getBaseUri() + "api/node/" + n.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
        return new NodesResponse(nodeResponses);

    }

    @GET
    @Path("/node/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @Timed
    public NodeResponse getNodeById(@PathParam("id") UUID nodeId) {
        Node node = nodeMapper.get(nodeId);
        return new NodeResponse(node,uriInfo.getBaseUri()+"api/node/" + nodeId);
    }

//
//    @POST
//    @Path("/nodes/connect-pre/{id}")
//    @Consumes({"application/json"})
//    @Produces({"application/json"})
//    @Timed
//    public NodeResponse connectPrereqNode(@PathParam("id") UUID nodeId, String req) {
//        Gson gson = new Gson();
//        ConnectPrereqNodeRequest request = gson.fromJson(req,ConnectPrereqNodeRequest.class);
//
//        return new NodeResponse(new Node(), uriInfo.getBaseUri()+"api/node/"  + nodeId);
//    }
//
//    @POST
//    @Path("/node/connect-post/{id}")
//    @Consumes({"application/json"})
//    @Produces({"application/json"})
//    @Timed
//    public NodeResponse connectLeadsToNode(@PathParam("id") UUID nodeId, String req) {
//        return new NodeResponse(new Node(), uriInfo.getBaseUri()+"api/node/"  + nodeId);
//        // TODO: implement me
//    }
//

}
