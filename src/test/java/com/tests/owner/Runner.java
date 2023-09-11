package com.tests.owner;

import com.utils.owner.FrameworkConfig;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Runner {


    public static void main(String[] args) {
        WebDriver driver = null;
        FrameworkConfig config = ConfigFactory.create(FrameworkConfig.class);
        System.out.println(config.browser());
//        driver.manage().timeouts().implicitlyWait(config.timeout(), config.value());
        config.favstools().forEach(System.out::println);
        System.out.println(config.timeout());
    }
}
