package com.pods;

import com.pods.resources.AuthResources;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class PodsApplication extends Application<PodsAppConfiguration> {

    public static void main(String[] args) {
        try {
            new PodsApplication().run(args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void run(PodsAppConfiguration podsAppConfiguration, Environment environment) throws Exception {
        environment.jersey().register(new AuthResources());
    }

}
