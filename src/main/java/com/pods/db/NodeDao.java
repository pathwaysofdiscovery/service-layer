package com.pods.db;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.pods.models.Node;

import java.util.*;

public class NodeDao {

    private final Session session;

    private final static String getNodesByTopicStmt = "select * from pods.nodes_by_topic where topic_id=?";
    private final static String getNodesByPrereqStmt = "";
    private final static String getNodesByLeadsToStmt = "";

    public NodeDao(Session session) {
        this.session = session;
    }

    public List<Node> getNodesByTopic(UUID topicId) {
        ResultSet rs = session.execute(getNodesByTopicStmt,topicId);
        List<Node> nodes = new ArrayList<Node>();
        for (Row row : rs.all()) {
            nodes.add(populateNode(row));
        }
        return nodes;
    }

    public Set<Node> getNodesByPrereq(UUID nodeId) {
        return new HashSet<Node>();
    }

    public Set<Node> getNodesByLeadsTo(UUID nodeId) {
        return new HashSet<Node>();
    }

    private Node populateNode(Row r) {
        Node node = new Node();
        node.setId(r.getUUID("node_id"));
        node.setTopicId(r.getUUID("topic_id"));
        return node;
    }
}