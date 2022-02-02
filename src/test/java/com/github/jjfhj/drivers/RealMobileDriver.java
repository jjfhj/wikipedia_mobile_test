package com.github.jjfhj.drivers;

import com.codeborne.selenide.WebDriverProvider;
import com.github.jjfhj.config.RealConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static com.github.jjfhj.utils.FileUtils.getAbsolutePath;

public class RealMobileDriver implements WebDriverProvider {

    private static final RealConfig REAL_CONFIG = ConfigFactory.create(RealConfig.class, System.getProperties());
    private static final String DEVICE_NAME = REAL_CONFIG.deviceName();
    private static final String PLATFORM_NAME = REAL_CONFIG.platformName();
    private static final String VERSION = REAL_CONFIG.version();
    private static final String LOCALE = REAL_CONFIG.locale();
    private static final String LANGUAGE = REAL_CONFIG.language();
    private static final String APP_PACKAGE = REAL_CONFIG.appPackage();
    private static final String APP_ACTIVITY = REAL_CONFIG.appActivity();
    private static final String APP = REAL_CONFIG.app();
    private static final String URL = REAL_CONFIG.remoteURL();

    public static URL getUrl() {
        try {
            return new URL(URL);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        desiredCapabilities.setCapability("deviceName", DEVICE_NAME);
        desiredCapabilities.setCapability("platformName", PLATFORM_NAME);
        desiredCapabilities.setCapability("version", VERSION);

        desiredCapabilities.setCapability("locale", LOCALE);
        desiredCapabilities.setCapability("language", LANGUAGE);

        desiredCapabilities.setCapability("appPackage", APP_PACKAGE);
        desiredCapabilities.setCapability("appActivity", APP_ACTIVITY);

        desiredCapabilities.setCapability("app",
                getAbsolutePath(APP));

        return new AndroidDriver(getUrl(), desiredCapabilities);
    }
}
