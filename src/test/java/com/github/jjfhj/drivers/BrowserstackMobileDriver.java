package com.github.jjfhj.drivers;

import com.codeborne.selenide.WebDriverProvider;
import com.github.jjfhj.config.CredentialsConfig;
import com.github.jjfhj.config.DeviceConfig;
import com.github.jjfhj.config.ProjectConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    private static final CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class, System.getProperties());
    private static final String user = credentials.user_name();
    private static final String key = credentials.access_key();
    private static final String app = credentials.appURL();
    private static final String url = credentials.remoteURL();

    private static final DeviceConfig config = ConfigFactory.create(DeviceConfig.class, System.getProperties());
    private static final String device = config.device();
    private static final String os_version = config.os_version();

    private static final ProjectConfig projectConfig = ConfigFactory.create(ProjectConfig.class, System.getProperties());
    private static final String project = projectConfig.project();
    private static final String build = projectConfig.build();
    private static final String name = projectConfig.name();

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
        desiredCapabilities.setCapability("project", project);
        desiredCapabilities.setCapability("build", build);
        desiredCapabilities.setCapability("name", name);

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        return new AndroidDriver(getBrowserstackUrl(), desiredCapabilities);
    }
}
