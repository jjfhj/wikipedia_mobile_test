package com.github.jjfhj.helpers;

import com.github.jjfhj.config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;

public class Browserstack {

    private static BrowserstackConfig browserstack = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
    private static String user = browserstack.user_name();
    private static String key = browserstack.access_key();

    public static String videoUrl(String sessionId) {
        return given()
                .auth().basic(user, key)
                .when()
                .get("https://api-cloud.browserstack.com/app-automate/sessions/" + sessionId + ".json")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .path("automation_session.video_url");
    }
}
