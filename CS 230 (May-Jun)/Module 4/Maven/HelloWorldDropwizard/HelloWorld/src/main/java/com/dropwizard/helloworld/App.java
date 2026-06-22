package com.dropwizard.helloworld;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class App extends Application<HelloWorldConfiguration> {
    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        // no initialization needed yet
    }

    @Override
    public void run(HelloWorldConfiguration configuration, Environment environment) {
        final HelloWorldResource resource = new HelloWorldResource();
        environment.jersey().register(resource);
    }
}
