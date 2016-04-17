package com.pods.db;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.pods.models.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ResourceDao {
    public final static Logger logger = LoggerFactory.getLogger(ResourceDao.class);

    private final Session session;

    private static String getResourcesForNodeStmt = "select * from pods.resources where node_id=?";

    public ResourceDao(Session session) {
        this.session = session;
    }

    public List<Resource> getResourcesForNode(UUID nodeId) {
        List<Resource> resourceList = new ArrayList<>();
        ResultSet rs = session.execute(getResourcesForNodeStmt, nodeId);
        for (Row r : rs) {
            Resource resource = populateResource(r);
            resourceList.add(resource);
        }
        return resourceList;
    }

    private Resource populateResource(Row r) {
        Resource resource = new Resource();
        resource.setId(r.getUUID("resource_id"));
        resource.setNodeId(r.getUUID("node_id"));
        resource.setTopicId(r.getUUID("topic_id"));
        resource.setRating(r.getInt("rating"));
        resource.setSource(r.getString("source"));
        resource.setTitle(r.getString("title"));
        resource.setContentUrl(r.getString("content_url"));
        return resource;
    }

}
