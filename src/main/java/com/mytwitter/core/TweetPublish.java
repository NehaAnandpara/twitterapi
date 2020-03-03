package com.mytwitter.core;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;


public class TweetPublish {
    public boolean PublishTweet(Twitter twitterInstance, String newPost) {
        try {
            twitterInstance.updateStatus(newPost);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

