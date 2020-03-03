package com.mytwitter.core;

import org.easymock.EasyMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import twitter4j.Twitter;

import static org.easymock.EasyMock.createMock;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class TweetPublishTest {
    TweetPublish tweetPublishInstance;
    Twitter twitterInstance;
    String tweet;

    @BeforeEach
    void setUp() {
        tweetPublishInstance = createMock(TweetPublish.class);
        twitterInstance = createMock(Twitter.class);
        tweet = "Hi, This is I am posting fom twitter application";
    }

    @Test
    void publishTweet() {
        EasyMock.expect(tweetPublishInstance.PublishTweet(twitterInstance, tweet)).andReturn(true).anyTimes();
        EasyMock.replay(tweetPublishInstance);
        boolean actualResponse = tweetPublishInstance.PublishTweet(twitterInstance, tweet);
        assertEquals(true,actualResponse);
    }
}