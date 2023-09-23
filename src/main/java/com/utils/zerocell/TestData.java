package com.utils.zerocell;

import com.creditdatamw.zerocell.annotation.Column;
import com.utils.enums.BrowserType;
import lombok.ToString;

import java.time.LocalDate;

@ToString
public class TestData {

    //POJO

    @Column(name = "TC", index = 0)
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
