package com.utils.owner;

import com.utils.enums.BrowserType;
import org.aeonbits.owner.Config;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Config.Sources(value = "file:${user.dir}/src/test/resources/FrameworkConfig.properties")
public interface FrameworkConfig extends Config {

    //type casted
    String browser();

    //Enum typed
    @DefaultValue("CHROME")
    BrowserType browser1();

    Long timeout();

    @DefaultValue("SECONDS")
    TimeUnit value();

    boolean takescreenshot();

    @Key("favtools")
    List<String> favstools();
}
