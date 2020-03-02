package com.mytwitter.resources;

import com.codahale.metrics.annotation.Timed;
import com.mytwitter.core.TweetPublish;
import com.mytwitter.core.UserTimeline;
import com.mytwitter.db.TwitterAuth;
import org.springframework.web.bind.annotation.RequestBody;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/1.0/twitter/")
@Produces(MediaType.APPLICATION_JSON)
public class TweetResource {



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
        return statuses;
    }

    @POST
    @Timed
    @Path("tweet")
    public ResponseList<Status> postTweet(@RequestBody String tweet){
        // implementation, create twitter instance, take string tweet, call TweetPublish.PublishTweet
        ResponseList<Status> timelineStatuses;
        Twitter twitterInstance = new TwitterFactory().getInstance();
        TwitterAuth setAuth = new TwitterAuth();
        setAuth.getAuth(twitterInstance);
        TweetPublish publishInstance = new TweetPublish();
        timelineStatuses = publishInstance.PublishTweet(twitterInstance, tweet);
        return timelineStatuses;
    }
}
