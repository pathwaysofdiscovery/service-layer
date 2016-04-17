package com.pods.db;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.pods.models.Topic;
import com.pods.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TopicDao {
    public final static Logger logger = LoggerFactory.getLogger(TopicDao.class);

    private final Session session;

    private static String getAllTopicsStmt = "select * from pods.topics;";
    private static String getTopicById = "select * from pods.topics where id=?";
    public TopicDao(Session session) {
        this.session = session;
    }

    public List<Topic> getAllTopics() {
        List<Topic> topicList = new ArrayList<>();
        ResultSet rs = session.execute(getAllTopicsStmt);
        for (Row r : rs) {
            topicList.add(populateTopic(r));
        }
        return topicList;
    }

    public Topic getTopicById(UUID id) {
        ResultSet rs = session.execute(getTopicById, id);
        Row r = rs.one();
        return populateTopic(r);

    }

    private Topic populateTopic(Row r) {
        Topic t = new Topic();
        t.setId(r.getUUID("id"));
        t.setTopicName(r.getString("name"));
        return t;
    }

}
