package com.github.jjfhj.drivers;

import com.codeborne.selenide.WebDriverProvider;
import com.github.jjfhj.config.BrowserstackConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    private static final BrowserstackConfig BROWSERSTACK_CONFIG = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
    private static final String USER = BROWSERSTACK_CONFIG.user_name();
    private static final String KEY = BROWSERSTACK_CONFIG.access_key();
    private static final String APP = BROWSERSTACK_CONFIG.appURL();
    private static final String URL = BROWSERSTACK_CONFIG.remoteURL();
    private static final String DEVICE = BROWSERSTACK_CONFIG.device();
    private static final String OS_VERSION = BROWSERSTACK_CONFIG.os_version();
    private static final String PROJECT = BROWSERSTACK_CONFIG.project();
    private static final String BUILD = BROWSERSTACK_CONFIG.build();
    private static final String NAME = BROWSERSTACK_CONFIG.name();

    public static URL getUrl() {
        try {
            return new URL(URL);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        // Set your access credentials
        desiredCapabilities.setCapability("browserstack.user", USER);
        desiredCapabilities.setCapability("browserstack.key", KEY);

        // Set URL of the application under test
        desiredCapabilities.setCapability("app", APP);

        // Specify device and os_version for testing
        desiredCapabilities.setCapability("device", DEVICE);
        desiredCapabilities.setCapability("os_version", OS_VERSION);

        // Set other BrowserStack capabilities
        desiredCapabilities.setCapability("project", PROJECT);
        desiredCapabilities.setCapability("build", BUILD);
        desiredCapabilities.setCapability("name", NAME);

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        return new AndroidDriver(getUrl(), desiredCapabilities);
    }
}
