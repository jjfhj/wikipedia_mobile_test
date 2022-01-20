package com.github.jjfhj.drivers;

import com.codeborne.selenide.WebDriverProvider;
import com.github.jjfhj.config.CredentialsConfig;
import com.github.jjfhj.config.DeviceConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    private static final CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class, System.getProperties());
    private static final String user = credentials.user();
    private static final String key = credentials.key();
    private static final String app = credentials.app();
    private static final String url = credentials.url();

    private static final DeviceConfig config = ConfigFactory.create(DeviceConfig.class, System.getProperties());
    private static final String device = config.device();
    private static final String os_version = config.os_version();

    public static URL getBrowserstackUrl() {
        try {
            return new URL(url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        // Set your access credentials
        desiredCapabilities.setCapability("browserstack.user", user);
        desiredCapabilities.setCapability("browserstack.key", key);

        // Set URL of the application under test
        desiredCapabilities.setCapability("app", app);

        // Specify device and os_version for testing
        desiredCapabilities.setCapability("device", device);
        desiredCapabilities.setCapability("os_version", os_version);

        // Set other BrowserStack capabilities
        desiredCapabilities.setCapability("project", "Java Project");
        desiredCapabilities.setCapability("build", "browserstack-build-1");
        desiredCapabilities.setCapability("name", "wikipedia_test");

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        return new AndroidDriver(getBrowserstackUrl(), desiredCapabilities);
    }
}
