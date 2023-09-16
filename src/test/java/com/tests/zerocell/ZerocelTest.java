package com.tests.zerocell;

import com.utils.enums.BrowserType;
import com.utils.factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ZerocelTest {


    @Test(dataProvider = "getdata")
    public void testcase1() {
        WebDriver driver = DriverFactory.getDriver(BrowserType.CHROME);
        driver.get("https://google.co.in");
        driver.findElement(By.name("q")).sendKeys();
        driver.quit();
    }

    @DataProvider
    public static Object[][] getdata() {
        return new Object[][]{};
    }
}
