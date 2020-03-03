package com.mytwitter.core;

import com.mytwitter.resources.TweetResource;
import org.easymock.EasyMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import twitter4j.*;
import twitter4j.json.DataObjectFactory;

import java.util.ArrayList;
import java.util.List;

import static org.easymock.EasyMock.createMock;
import static org.junit.Assert.assertEquals;

class UserTimelineTest {
    UserTimeline userTimelineInstance;

    Twitter twitterInstance;
    String twitterResponse;
    List<Status> list ;
    ResponseList<Status> responseList;

    @BeforeEach
    void setUp() throws JSONException, TwitterException {
        userTimelineInstance = new UserTimeline();
        twitterInstance = createMock(Twitter.class);
        twitterResponse = "[{ \"rateLimitStatus\": null, \"accessLevel\": 0, \"createdAt\": 1532452066000, \"id\": 1021804143579746304, \"text\": \"RT @abpnewshindi: पीएम @narendramodi ने रवांडा में ग्रामीणों को दान में दी 200 गायें\\n\\nhttps://t.co/VNmQhlSw7g\", \"displayTextRangeStart\": -1, \"displayTextRangeEnd\": -1, \"source\": \"<a href=\\\"http://twitter.com\\\" rel=\\\"nofollow\\\">Twitter Web Client</a>\", \"inReplyToStatusId\": -1, \"inReplyToUserId\": -1, \"favoriteCount\": 0, \"inReplyToScreenName\": null, \"geoLocation\": null, \"place\": null, \"retweetCount\": 56, \"lang\": \"hi\", \"retweetedStatus\": { \"rateLimitStatus\": null, \"accessLevel\": 0, \"createdAt\": 1532429718000, \"id\": 1021710406451187713, \"text\": \"पीएम @narendramodi ने रवांडा में ग्रामीणों को दान में दी 200 गायें\\n\\nhttps://t.co/VNmQhlSw7g\", \"displayTextRangeStart\": -1, \"displayTextRangeEnd\": -1, \"source\": \"<a href=\\\"http://twitter.com\\\" rel=\\\"nofollow\\\">Twitter Web Client</a>\", \"inReplyToStatusId\": -1, \"inReplyToUserId\": -1, \"favoriteCount\": 399, \"inReplyToScreenName\": null, \"geoLocation\": null, \"place\": null, \"retweetCount\": 56, \"lang\": \"hi\", \"retweetedStatus\": null, \"userMentionEntities\": [{ \"start\": 5, \"end\": 18, \"name\": \"Narendra Modi\", \"screenName\": \"narendramodi\", \"id\": 18839785, \"text\": \"narendramodi\" }], \"hashtagEntities\": [], \"mediaEntities\": [], \"symbolEntities\": [], \"currentUserRetweetId\": -1, \"scopes\": null, \"user\": { \"rateLimitStatus\": null, \"accessLevel\": 0, \"id\": 333888813, \"name\": \"ABP न्यूज़ हिंदी\", \"email\": null, \"screenName\": \"abpnewshindi\", \"location\": \"New Delhi\", \"description\": \"ABP News is a hindi news channel featuring news around the world on politics ,sports,business and entertainment.Follow us for latest news and updates.\", \"descriptionURLEntities\": [], \"url\": \"https://t.co/O9xUxqWf3L\", \"followersCount\": 1483174, \"status\": null, \"profileBackgroundColor\": \"DBE9ED\", \"profileTextColor\": \"333333\", \"profileLinkColor\": \"CC3366\", \"profileSidebarFillColor\": \"E6F6F9\", \"profileSidebarBorderColor\": \"000000\", \"profileUseBackgroundImage\": true, \"showAllInlineMedia\": false, \"friendsCount\": 103, \"createdAt\": 1310455411000, \"favouritesCount\": 161, \"utcOffset\": -1, \"timeZone\": null, \"profileBackgroundImageUrlHttps\": \"https://abs.twimg.com/images/themes/theme17/bg.gif\", \"profileBackgroundTiled\": false, \"lang\": null, \"statusesCount\": 189094, \"translator\": false, \"listedCount\": 1022, \"withheldInCountries\": null, \"protected\": false, \"contributorsEnabled\": false, \"profileImageURL\": \"http://pbs.twimg.com/profile_images/821590583873564672/o1xDWjix_normal.jpg\", \"biggerProfileImageURL\": \"http://pbs.twimg.com/profile_images/821590583873564672/o1xDWjix_bigger.jpg\", \"miniProfileImageURL\": \"http://pbs.twimg.com/profile_images/821590583873564672/o1xDWjix_mini.jpg\", \"originalProfileImageURL\": \"http://pbs.twimg.com/profile_images/821590583873564672/o1xDWjix.jpg\", \"profileImageURLHttps\": \"https://pbs.twimg.com/profile_images/821590583873564672/o1xDWjix_normal.jpg\", \"biggerProfileImageURLHttps\": \"https://pbs.twimg.com/profile_images/821590583873564672/o1xDWjix_bigger.jpg\", \"miniProfileImageURLHttps\": \"https://pbs.twimg.com/profile_images/821590583873564672/o1xDWjix_mini.jpg\", \"originalProfileImageURLHttps\": \"https://pbs.twimg.com/profile_images/821590583873564672/o1xDWjix.jpg\", \"defaultProfileImage\": false, \"defaultProfile\": false, \"verified\": true, \"profileBackgroundImageURL\": \"http://abs.twimg.com/images/themes/theme17/bg.gif\", \"profileBannerURL\": \"https://pbs.twimg.com/profile_banners/333888813/1562834349/web\", \"profileBannerRetinaURL\": \"https://pbs.twimg.com/profile_banners/333888813/1562834349/web_retina\", \"profileBannerIPadURL\": \"https://pbs.twimg.com/profile_banners/333888813/1562834349/ipad\", \"profileBannerIPadRetinaURL\": \"https://pbs.twimg.com/profile_banners/333888813/1562834349/ipad_retina\", \"profileBannerMobileURL\": \"https://pbs.twimg.com/profile_banners/333888813/1562834349/mobile\", \"profileBannerMobileRetinaURL\": \"https://pbs.twimg.com/profile_banners/333888813/1562834349/mobile_retina\", \"geoEnabled\": true, \"followRequestSent\": false, \"urlentity\": { \"start\": 0, \"end\": 23, \"url\": \"https://t.co/O9xUxqWf3L\", \"expandedURL\": \"http://abpnews.in/\", \"displayURL\": \"abpnews.in\", \"text\": \"https://t.co/O9xUxqWf3L\" } }, \"withheldInCountries\": null, \"quotedStatus\": null, \"quotedStatusId\": -1, \"truncated\": false, \"favorited\": false, \"retweet\": false, \"retweeted\": true, \"contributors\": [], \"retweetedByMe\": false, \"possiblySensitive\": false, \"urlentities\": [{ \"start\": 68, \"end\": 91, \"url\": \"https://t.co/VNmQhlSw7g\", \"expandedURL\": \"https://abpnews.abplive.in/india-news/pm-modi-gives-200-cows-in-donations-to-villagers-in-rwanda-921520\", \"displayURL\": \"abpnews.abplive.in/india-news/pm-…\", \"text\": \"https://t.co/VNmQhlSw7g\" }] }, \"userMentionEntities\": [{ \"start\": 3, \"end\": 16, \"name\": \"ABP न्यूज़ हिंदी\", \"screenName\": \"abpnewshindi\", \"id\": 333888813, \"text\": \"abpnewshindi\" }, { \"start\": 23, \"end\": 36, \"name\": \"Narendra Modi\", \"screenName\": \"narendramodi\", \"id\": 18839785, \"text\": \"narendramodi\" } ], \"hashtagEntities\": [], \"mediaEntities\": [], \"symbolEntities\": [], \"currentUserRetweetId\": -1, \"scopes\": null, \"user\": { \"rateLimitStatus\": null, \"accessLevel\": 0, \"id\": 1919902128, \"name\": \"Neha Anandpara\", \"email\": null, \"screenName\": \"AnandparaNeha\", \"location\": \"\", \"description\": \"\", \"descriptionURLEntities\": [], \"url\": null, \"followersCount\": 8, \"status\": null, \"profileBackgroundColor\": \"C0DEED\", \"profileTextColor\": \"333333\", \"profileLinkColor\": \"1DA1F2\", \"profileSidebarFillColor\": \"DDEEF6\", \"profileSidebarBorderColor\": \"C0DEED\", \"profileUseBackgroundImage\": true, \"showAllInlineMedia\": false, \"friendsCount\": 200, \"createdAt\": 1380544365000, \"favouritesCount\": 14, \"utcOffset\": -1, \"timeZone\": null, \"profileBackgroundImageUrlHttps\": \"https://abs.twimg.com/images/themes/theme1/bg.png\", \"profileBackgroundTiled\": false, \"lang\": null, \"statusesCount\": 15, \"translator\": false, \"listedCount\": 0, \"withheldInCountries\": null, \"protected\": false, \"contributorsEnabled\": false, \"profileImageURL\": \"http://abs.twimg.com/sticky/default_profile_images/default_profile_normal.png\", \"biggerProfileImageURL\": \"http://abs.twimg.com/sticky/default_profile_images/default_profile_bigger.png\", \"miniProfileImageURL\": \"http://abs.twimg.com/sticky/default_profile_images/default_profile_mini.png\", \"originalProfileImageURL\": \"http://abs.twimg.com/sticky/default_profile_images/default_profile.png\", \"profileImageURLHttps\": \"https://abs.twimg.com/sticky/default_profile_images/default_profile_normal.png\", \"biggerProfileImageURLHttps\": \"https://abs.twimg.com/sticky/default_profile_images/default_profile_bigger.png\", \"miniProfileImageURLHttps\": \"https://abs.twimg.com/sticky/default_profile_images/default_profile_mini.png\", \"originalProfileImageURLHttps\": \"https://abs.twimg.com/sticky/default_profile_images/default_profile.png\", \"defaultProfileImage\": true, \"defaultProfile\": true, \"verified\": false, \"profileBackgroundImageURL\": \"http://abs.twimg.com/images/themes/theme1/bg.png\", \"profileBannerURL\": null, \"profileBannerRetinaURL\": null, \"profileBannerIPadURL\": null, \"profileBannerIPadRetinaURL\": null, \"profileBannerMobileURL\": null, \"profileBannerMobileRetinaURL\": null, \"geoEnabled\": false, \"followRequestSent\": false, \"urlentity\": { \"start\": 0, \"end\": 0, \"url\": \"\", \"expandedURL\": \"\", \"displayURL\": \"\", \"text\": \"\" } }, \"withheldInCountries\": null, \"quotedStatus\": null, \"quotedStatusId\": -1, \"truncated\": false, \"favorited\": false, \"retweet\": true, \"retweeted\": true, \"contributors\": [], \"retweetedByMe\": false, \"possiblySensitive\": false, \"urlentities\": [{ \"start\": 86, \"end\": 109, \"url\": \"https://t.co/VNmQhlSw7g\", \"expandedURL\": \"https://abpnews.abplive.in/india-news/pm-modi-gives-200-cows-in-donations-to-villagers-in-rwanda-921520\", \"displayURL\": \"abpnews.abplive.in/india-news/pm-…\", \"text\": \"https://t.co/VNmQhlSw7g\" }] }]";

        JSONArray array = new JSONArray(twitterResponse);
        list = new ArrayList<>();
        if (array.length() > 0) {
            for (int x = 0; x < array.length(); x++) {
                JSONObject obj = (JSONObject) array.get(x);
                Status status = DataObjectFactory.createStatus(obj.toString());
                list.add(status);
            }
        }

        responseList = EasyMock.createMock(ResponseList.class);
        EasyMock.expect(responseList.toArray(EasyMock.isA(Status[].class))).andDelegateTo(list).anyTimes();
        EasyMock.replay(responseList);
    }

    @Test
    void getTimeline() throws TwitterException {
        EasyMock.expect(twitterInstance.getUserTimeline()).andReturn(responseList).anyTimes();
        EasyMock.replay(twitterInstance);
        ResponseList<Status> actualResponseList = userTimelineInstance.GetTimeline(twitterInstance);
        assertEquals(true,actualResponseList.equals(responseList));
    }
}