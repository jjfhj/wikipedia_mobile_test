package com.github.jjfhj.helpers;

import com.github.jjfhj.config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;

public class BrowserstackVideo {

    private static final BrowserstackConfig BROWSERSTACK_CONFIG = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
    private static final String USER = BROWSERSTACK_CONFIG.user_name();
    private static final String KEY = BROWSERSTACK_CONFIG.access_key();

    public static String getVideoUrl(String sessionId) {
        return given()
                .auth().basic(USER, KEY)
                .when()
                .get("https://api-cloud.browserstack.com/app-automate/sessions/" + sessionId + ".json")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .path("automation_session.video_url");
    }
}
