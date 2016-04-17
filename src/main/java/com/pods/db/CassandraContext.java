package com.pods.db;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

import javax.print.attribute.standard.Compression;

/**
 * Created by jshook on 4/16/16.
 */
public class CassandraContext {

    private Session session;
    private Cluster cluster;

    public synchronized Session getSession() {
        if (session==null) {
            session=getCluster().newSession();
        }
        return session;
    }

    public synchronized Cluster getCluster() {
        if (cluster==null) {
            cluster = Cluster.builder()
//                    .withCompression(Compression.DEFLATE)
        //            .withCredentials("dbuser1","dbpass2")
                    .addContactPoints("www.pathwaysofdiscovery.online")
                    .build();
        }
        return cluster;
    }
}
