package com.utils.zerocell;

import com.creditdatamw.zerocell.annotation.Column;
import com.utils.enums.BrowserType;

import java.time.LocalDate;

public class TestData {

    //POJO

    @Column(name = "testcase", index = 0)
    private String testcase;

    @Column(name = "browser", index = 1, converterClass = StringToBrowserTypeConverter.class)
    private BrowserType browser;

    @Column(name = "firstname", index = 2)
    private String firstname;

    @Column(name = "isFTE", index = 3, converterClass = StringToBooleanConverter.class)
    private boolean isFTE;

    @Column(name = "age", index = 4, converterClass = StringToIntegerConverter.class)
    private int age;

    @Column(name = "date", index = 5, converterClass = StringToLocalDateConverter.class)
    private LocalDate date;

    @Column(name = "phonenumber", index = 6, converterClass = PhoneNumberProcessor.class)
    private String phonenumber;

    @Override
    public String toString() {
        return "TestData{" +
                "testcase='" + testcase + '\'' +
                ", browser='" + browser + '\'' +
                ", firstname='" + firstname + '\'' +
                ", isFTE=" + isFTE +
                ", age=" + age +
                ", date=" + date +
                ", phonenumber='" + phonenumber + '\'' +
                '}';
    }

    public String getTestcase() {
        return testcase;
    }

    public BrowserType getBrowser() {
        return browser;
    }

    public String getFirstname() {
        return firstname;
    }

    public boolean isFTE() {
        return isFTE;
    }

    public int getAge() {
        return age;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getPhonenumber() {
        return phonenumber;
    }
}
