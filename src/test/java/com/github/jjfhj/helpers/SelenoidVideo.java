package com.github.jjfhj.helpers;

import com.github.jjfhj.config.SelenoidConfig;
import org.aeonbits.owner.ConfigFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class SelenoidVideo {

    private static final SelenoidConfig SELENOID_CONFIG = ConfigFactory.create(SelenoidConfig.class, System.getProperties());
    private static final String VIDEO_STORAGE_URL = SELENOID_CONFIG.videoStorageURL();

    public static URL getVideoUrl(String sessionId) {
        String videoUrl = VIDEO_STORAGE_URL + sessionId + ".mp4";

        try {
            return new URL(videoUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
