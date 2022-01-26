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

    private static final RealConfig real = ConfigFactory.create(RealConfig.class, System.getProperties());
    private static final String deviceName = real.deviceName();
    private static final String platformName = real.platformName();
    private static final String version = real.version();
    private static final String locale = real.locale();
    private static final String language = real.language();
    private static final String appPackage = real.appPackage();
    private static final String appActivity = real.appActivity();
    private static final String app = real.app();
    private static final String url = real.remoteURL();

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
