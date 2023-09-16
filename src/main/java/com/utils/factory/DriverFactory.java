package com.utils.factory;

import com.utils.enums.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {
    private DriverFactory(){}

    public static WebDriver getDriver(BrowserType browserType){
        if(BrowserType.CHROME == browserType){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
        else if(BrowserType.FIREFOX == browserType){
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        }
        else throw new RuntimeException("Pass correct browser type");
    }
}
