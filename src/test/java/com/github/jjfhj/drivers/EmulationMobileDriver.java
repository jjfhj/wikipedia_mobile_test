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

    private static final EmulationConfig emulation = ConfigFactory.create(EmulationConfig.class, System.getProperties());
    private static final String deviceName = emulation.deviceName();
    private static final String platformName = emulation.platformName();
    private static final String version = emulation.version();
    private static final String locale = emulation.locale();
    private static final String language = emulation.language();
    private static final String appPackage = emulation.appPackage();
    private static final String appActivity = emulation.appActivity();
    private static final String app = emulation.app();
    private static final String url = emulation.remoteURL();

    public static URL getUrl() {
        try {
            return new URL(url);
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

        desiredCapabilities.setCapability("app",
                getAbsolutePath(app));

        return new AndroidDriver(getUrl(), desiredCapabilities);
    }
}
