package com.github.jjfhj.drivers;

import com.codeborne.selenide.WebDriverProvider;
import com.github.jjfhj.config.EmulationConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static com.github.jjfhj.utils.FileUtils.getAbsolutePath;

public class EmulationMobileDriver implements WebDriverProvider {

    private static final EmulationConfig EMULATION_CONFIG = ConfigFactory.create(EmulationConfig.class, System.getProperties());
    private static final String DEVICE_NAME = EMULATION_CONFIG.deviceName();
    private static final String PLATFORM_NAME = EMULATION_CONFIG.platformName();
    private static final String VERSION = EMULATION_CONFIG.version();
    private static final String LOCALE = EMULATION_CONFIG.locale();
    private static final String LANGUAGE = EMULATION_CONFIG.language();
    private static final String APP_PACKAGE = EMULATION_CONFIG.appPackage();
    private static final String APP_ACTIVITY = EMULATION_CONFIG.appActivity();
    private static final String APP = EMULATION_CONFIG.app();
    private static final String URL = EMULATION_CONFIG.remoteURL();

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
