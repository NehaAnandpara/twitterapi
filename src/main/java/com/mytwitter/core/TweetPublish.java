package com.mytwitter.core;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;


public class TweetPublish {
    public ResponseList<Status> PublishTweet(Twitter twitterInstance, String newPost) {
        try {
            twitterInstance.updateStatus(newPost);
        } catch (TwitterException te) {
            te.printStackTrace();
        }
        return null;
    }
}

