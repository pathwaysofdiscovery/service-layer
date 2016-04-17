package com.pods.db;

import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import com.pods.models.*;

public class DbMappers {

    private final Session session;
    private final Mapper<User> userMapper;
    private final Mapper<Topic> topicMapper;
    private final Mapper<Node> nodeMapper;
    private final Mapper<NodeByTopic> nodeByTopicMapper;
    private final Mapper<Resource> resourceMapper;
    private final TopicDao topicDao;
    private final NodeDao nodeDao;
    private final ResourceDao resourceDao;

    private MappingManager mappingManager;

    public DbMappers(Session session) {
        this.session = session;
        this.mappingManager = new MappingManager(session);
        this.userMapper = mappingManager.mapper(User.class);
        this.topicMapper = mappingManager.mapper(Topic.class);
        this.nodeMapper = mappingManager.mapper(Node.class);
        this.nodeByTopicMapper = mappingManager.mapper(NodeByTopic.class);
        this.resourceMapper = mappingManager.mapper(Resource.class);
        this.topicDao = new TopicDao(session);
        this.nodeDao = new NodeDao(session);
        this.resourceDao = new ResourceDao(session);
    }

    public Mapper<User> getUserMapper() {
        return userMapper;
    }

    public Mapper<Topic> getTopicMapper() {
        return topicMapper;
    }

    public Mapper<Node> getNodeMapper() {
        return nodeMapper;
    }
    public Mapper<NodeByTopic> getNodeByTopicMapper() { return nodeByTopicMapper; }

    public Mapper<Resource> getResourceMapper() {
        return resourceMapper;
    }

    public TopicDao getTopicDao() {
        return topicDao;
    }

    public NodeDao getNodeDao() {
        return nodeDao;
    }

    public ResourceDao getResourceDao() {
        return resourceDao;
    }
}
