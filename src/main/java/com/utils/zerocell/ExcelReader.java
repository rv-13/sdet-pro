package com.utils.zerocell;

import com.creditdatamw.zerocell.Reader;

import java.io.File;
import java.util.List;

public final class ExcelReader {

    private ExcelReader() {
    }

    private static List<TestData> testdata = null;

    public static List<TestData> getTestdata() {
        return testdata;
    }

    static {
        testdata = Reader.of(TestData.class)
                .from(new File("testdata.xlsx"))
                .sheet("sheet1")
                .skipHeaderRow(true)
                .list();
    }

}
