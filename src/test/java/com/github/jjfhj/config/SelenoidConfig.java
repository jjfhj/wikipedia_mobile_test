package com.github.jjfhj.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/selenoid.properties"})
public interface SelenoidConfig extends Config {

    @Key("selenoidURL")
    String selenoidURL();

    @Key("login")
    String login();

    @Key("password")
    String password();

    @Key("deviceName")
    String deviceName();

    @Key("platformName")
    String platformName();

    @Key("version")
    String version();

    @Key("locale")
    String locale();

    @Key("language")
    String language();

    @Key("appPackage")
    String appPackage();

    @Key("appActivity")
    String appActivity();

    @Key("app")
    String app();

    @Key("videoStorageURL")
    String videoStorageURL();
}
