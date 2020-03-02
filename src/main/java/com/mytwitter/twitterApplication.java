package com.mytwitter;

import com.mytwitter.resources.TweetResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import twitter4j.TwitterException;

public class twitterApplication extends Application<twitterConfiguration> {

    public static void main(final String[] args) throws Exception {
        new twitterApplication().run(args);
    }

    @Override
    public String getName() {
        return "twitter";
    }

    @Override
    public void initialize(final Bootstrap<twitterConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final twitterConfiguration configuration,
                    final Environment environment) throws TwitterException {
            TweetResource eventResource = new TweetResource();
            environment.jersey().register(eventResource);
    }

}
