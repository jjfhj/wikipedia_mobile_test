package com.github.jjfhj.helpers;

import com.github.jjfhj.config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;

public class Browserstack {

    private static CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class, System.getProperties());
    private static String user = credentials.user();
    private static String key = credentials.key();

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
