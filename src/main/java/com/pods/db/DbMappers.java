package com.pods.db;

import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import com.pods.models.Node;
import com.pods.models.Resource;
import com.pods.models.Topic;
import com.pods.models.User;

public class DbMappers {

    private final Session session;
    private final Mapper<User> userMapper;
    private final Mapper<Topic> topicMapper;
    private final Mapper<Node> NodeMapper;
    private final Mapper<Resource> resourceMapper;
    private final TopicDao topicDao;

    private MappingManager mappingManager;

    public DbMappers(Session session) {
        this.session = session;
        this.mappingManager = new MappingManager(session);
        this.userMapper = mappingManager.mapper(User.class);
        this.topicMapper = mappingManager.mapper(Topic.class);
        this.NodeMapper = mappingManager.mapper(Node.class);
        this.resourceMapper = mappingManager.mapper(Resource.class);
        this.topicDao = new TopicDao(session);
    }

    public Mapper<User> getUserMapper() {
        return userMapper;
    }

    public Mapper<Topic> getTopicMapper() {
        return topicMapper;
    }

    public Mapper<Node> getNodeMapper() {
        return NodeMapper;
    }

    public Mapper<Resource> getResourceMapper() {
        return resourceMapper;
    }

    public TopicDao getTopicDao() {
        return topicDao;
    }
}
