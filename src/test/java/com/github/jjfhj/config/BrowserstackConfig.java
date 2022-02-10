package com.github.jjfhj.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "system:properties",
        "file:/tmp/browserstack.properties",
        "classpath:config/browserstack.properties"
})
public interface BrowserstackConfig extends Config {

    @Key("user_name")
    String user_name();

    @Key("access_key")
    String access_key();

    @Key("appURL")
    String appURL();

    @Key("remoteURL")
    String remoteURL();

    @Key("device")
    String device();

    @Key("os_version")
    String os_version();

    @Key("project")
    String project();

    @Key("build")
    String build();

    @Key("name")
    String name();
}
