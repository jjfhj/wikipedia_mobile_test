package com.github.jjfhj.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/credentials.properties"})
public interface CredentialsConfig extends Config {

    @Key("user_name")
    String user_name();

    @Key("access_key")
    String access_key();

    @Key("appURL")
    String appURL();

    @Key("remoteURL")
    String remoteURL();
}
