package com.github.jjfhj.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "file:/tmp/real.properties",
        "classpath:config/real.properties"
})
public interface RealConfig extends Config {

//    @Key("deviceName")
    String deviceName();

//    @Key("platformName")
    String platformName();

//    @Key("version")
    String version();

//    @Key("locale")
    String locale();

//    @Key("language")
    String language();

//    @Key("appPackage")
    String appPackage();

//    @Key("appActivity")
    String appActivity();

//    @Key("app")
    String app();

//    @Key("remoteURL")
    String remoteURL();
}
