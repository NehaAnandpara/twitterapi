package com.mytwitter.db;

import twitter4j.Twitter;
import twitter4j.auth.AccessToken;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TwitterAuth {

    public void getAuth(Twitter twitterInstance) {
        try (InputStream input = new FileInputStream("src/main/resources/credentials.properties")) {
            Properties prop = new Properties();
            prop.load(input);

            String consumerKeyStr = prop.getProperty("oauth.consumerKey");
            String consumerSecretStr = prop.getProperty("oauth.consumerSecret");
            String accessTokenStr = prop.getProperty("oauth.accessToken");
            String accessTokenSecretStr = prop.getProperty("oauth.accessTokenSecret");


            twitterInstance.setOAuthConsumer(consumerKeyStr, consumerSecretStr);
            AccessToken accessToken = new AccessToken(accessTokenStr,
                    accessTokenSecretStr);

            twitterInstance.setOAuthAccessToken(accessToken);

        } catch (FileNotFoundException te) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
