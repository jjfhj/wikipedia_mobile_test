package com.github.jjfhj.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/credentials.properties"})
public interface CredentialsConfig extends Config {

    @Key("user")
    String user();

    @Key("key")
    String key();

    @Key("app")
    String app();

    @Key("url")
    String url();
}
