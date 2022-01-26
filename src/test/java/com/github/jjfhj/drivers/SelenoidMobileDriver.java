package com.github.jjfhj.drivers;

import com.codeborne.selenide.WebDriverProvider;
import com.github.jjfhj.config.SelenoidConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.String.format;

public class SelenoidMobileDriver implements WebDriverProvider {

    private static final SelenoidConfig selenoid = ConfigFactory.create(SelenoidConfig.class, System.getProperties());
    private static final String selenoidURL = selenoid.selenoidURL();
    private static final String login = selenoid.login();
    private static final String password = selenoid.password();
    private static final String deviceName = selenoid.deviceName();
    private static final String platformName = selenoid.platformName();
    private static final String version = selenoid.version();
    private static final String locale = selenoid.locale();
    private static final String language = selenoid.language();
    private static final String appPackage = selenoid.appPackage();
    private static final String appActivity = selenoid.appActivity();
    private static final String app = selenoid.app();
    private static String remoteURL = format("https://%s:%s@%s", login, password, selenoidURL);

    public static URL getUrl() {
        try {
            return new URL(remoteURL);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        desiredCapabilities.setCapability("deviceName", deviceName);
        desiredCapabilities.setCapability("platformName", platformName);
        desiredCapabilities.setCapability("version", version);

        desiredCapabilities.setCapability("locale", locale);
        desiredCapabilities.setCapability("language", language);

        desiredCapabilities.setCapability("appPackage", appPackage);
        desiredCapabilities.setCapability("appActivity", appActivity);

        desiredCapabilities.setCapability("app", apkUrl());

        desiredCapabilities.setCapability("enableVNC", true);
        desiredCapabilities.setCapability("enableVideo", true);

        return new AndroidDriver(getUrl(), desiredCapabilities);
    }

    private URL apkUrl() {
        try {
            return new URL(app);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
