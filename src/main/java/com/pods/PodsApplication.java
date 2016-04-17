package com.pods;

import com.pods.db.CassandraContext;
import com.pods.db.DbMappers;
import com.pods.resources.*;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class PodsApplication extends Application<PodsAppConfiguration> {

    private final CassandraContext cctx;
    private final DbMappers dbm;

    public static void main(String[] args) {
        try {
            new PodsApplication().run(args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public PodsApplication() {
        this.cctx = new CassandraContext();
        this.dbm = new DbMappers(cctx.getSession());
    }

    public void run(PodsAppConfiguration podsAppConfiguration, Environment environment) throws Exception {
        environment.jersey().register(new AuthResources(dbm.getUserMapper()));
        environment.jersey().register(new UserResources(dbm.getUserMapper()));
        environment.jersey().register(new TopicResources(dbm.getTopicMapper(), dbm.getTopicDao()));
        environment.jersey().register(new NodeResources(dbm.getNodeMapper(), dbm.getNodeByTopicMapper(),dbm.getNodeDao()));
        environment.jersey().register(new ResourceResources(dbm.getResourceMapper(),dbm.getResourceDao()));
    }

}
