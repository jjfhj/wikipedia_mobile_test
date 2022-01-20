package com.github.jjfhj.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/project.properties"})
public interface ProjectConfig extends Config {

    @Key("project")
    String project();

    @Key("build")
    String build();

    @Key("name")
    String name();
}
