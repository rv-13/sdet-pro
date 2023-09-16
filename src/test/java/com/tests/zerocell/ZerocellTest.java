package com.tests.zerocell;

import com.utils.enums.BrowserType;
import com.utils.factory.DriverFactory;
import com.utils.zerocell.ExcelReader;
import com.utils.zerocell.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;


public class ZerocellTest {


    @Test(dataProvider = "getdata")
    public void testcase1(TestData data) {
        WebDriver driver = DriverFactory.getDriver(data.getBrowser());
        driver.get("https://google.co.in");
        driver.findElement(By.name("q")).sendKeys(data.getFirstname());
        driver.quit();
    }

    @DataProvider
    public static Object[] getdata() {
        List<TestData> testdata = ExcelReader.getTestdata();
        return testdata.toArray();
    }

}

