package com.utils.owner;

import org.aeonbits.owner.Config;

import java.util.List;

public interface FrameworkConfig extends Config {

    String browser();

    Long timeout();

    boolean takescreenshot();

    List<String> favtools();
}
