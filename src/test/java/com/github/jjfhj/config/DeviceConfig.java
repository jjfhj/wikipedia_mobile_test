package com.github.jjfhj.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/device.properties"})
public interface DeviceConfig extends Config {

    @Config.Key("device")
    String device();

    @Config.Key("os_version")
    String os_version();
}
