package com.pods.resources;

import com.codahale.metrics.annotation.Timed;
import com.datastax.driver.core.utils.UUIDs;
import com.datastax.driver.mapping.Mapper;
import com.google.gson.Gson;
import com.pods.db.ResourceDao;
import com.pods.models.Resource;
import com.pods.resp.ResourceResponse;
import com.pods.resp.ResourcesResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Path("/api")
public class ResourceResources {

    private final ResourceDao resourceDao;
    private Mapper<Resource> resourceMapper;

    @Context
    UriInfo uriInfo;

    public ResourceResources(Mapper<Resource> resourceMapper, ResourceDao resourceDao) {
        this.resourceMapper = resourceMapper;
        this.resourceDao = resourceDao;
    }

    @POST
    @Path("/resources/create")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @Timed
    public ResourceResponse createResource(String res) {
        Gson gson = new Gson();
        com.pods.models.Resource resource = gson.fromJson(res,Resource.class);
        UUID uuid = UUIDs.timeBased();
        resource.setId(uuid);
        resourceMapper.save(resource);
        return new ResourceResponse(resource,uriInfo.getBaseUri()+"api/resource/"+uuid.toString());
    }

    @GET
    @Path("/resources/bynode/{node_id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @Timed
    public ResourcesResponses getResourcesByNode(@PathParam("node_id") String nodeId) {
        List<Resource> resources = resourceDao.getResourcesForNode(UUID.fromString(nodeId));
        ArrayList<ResourceResponse> resourceResponses = resources.stream()
                .map(r -> new ResourceResponse(r, uriInfo.getBaseUri() + "api/resource/" + r.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
        return new ResourcesResponses(resourceResponses);

    }

}
