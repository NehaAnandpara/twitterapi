package com.mytwitter.core;

import org.easymock.EasyMock;
import org.easymock.IExpectationSetters;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.omg.CORBA.Any;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class TweetPublishTest {
    TweetPublish tweetPublishInstance;

    Twitter twitterInstance;
    String tweet;

    @BeforeEach
    void setUp() {
        tweetPublishInstance = new TweetPublish();
        twitterInstance = EasyMock.createMock(Twitter.class);
        tweet = "Hi, This is I am posting fom twitter application";
    }

    @Test
    void publishTweet() throws TwitterException {
        expect(twitterInstance.updateStatus (tweet)).andReturn(null);
        EasyMock.replay(twitterInstance);
        boolean actualResponse = tweetPublishInstance.PublishTweet(twitterInstance, tweet);
        assertEquals(true,actualResponse);
    }
}