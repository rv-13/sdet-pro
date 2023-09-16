package com.tests.zerocell;

import com.creditdatamw.zerocell.Reader;
import com.utils.zerocell.TestData;

import java.io.File;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<TestData> testdata = Reader.of(TestData.class)
                .from(new File("testdata.xlsx"))
                .sheet("sheet1")
                .skipHeaderRow(true)
                .list();

        testdata.forEach(System.out::println);
    }
}
