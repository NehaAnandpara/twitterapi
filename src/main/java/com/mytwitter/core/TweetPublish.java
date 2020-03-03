package com.mytwitter.core;

import twitter4j.Twitter;

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

