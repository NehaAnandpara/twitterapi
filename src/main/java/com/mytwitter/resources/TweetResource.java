package com.mytwitter.resources;

import com.codahale.metrics.annotation.Timed;
import com.mytwitter.core.TweetPublish;
import com.mytwitter.core.UserTimeline;
import com.mytwitter.db.TwitterAuth;
import org.springframework.web.bind.annotation.RequestBody;
import twitter4j.*;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/1.0/twitter/")
@Produces(MediaType.APPLICATION_JSON)
public class TweetResource {

     boolean postStatus;

    @GET
    @Timed
    @Path("timeline")
    public ResponseList<Status> getTweets(){
        // implementation , create twitter instance here and call UserTimeline.GetTimeline
        ResponseList<Status> statuses;
        Twitter twitterInstance = new TwitterFactory().getInstance();
        TwitterAuth setAuth = new TwitterAuth();
        setAuth.getAuth(twitterInstance);
        UserTimeline userTimelineInstance = new UserTimeline();
        statuses = userTimelineInstance.GetTimeline(twitterInstance);
        System.out.println(statuses);
        return statuses;
    }

    @POST
    @Timed
    @Path("tweet")
    public boolean postTweet(@RequestBody String tweet) {
        // implementation, create twitter instance, take string tweet, call TweetPublish.PublishTweet
        Twitter twitterInstance = new TwitterFactory().getInstance();
        TwitterAuth setAuth = new TwitterAuth();
        setAuth.getAuth(twitterInstance);
        TweetPublish publishInstance = new TweetPublish();
        postStatus = publishInstance.PublishTweet(twitterInstance, tweet);
        return postStatus;

    }
}
