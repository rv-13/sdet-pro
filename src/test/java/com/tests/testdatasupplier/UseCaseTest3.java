package com.tests.testdatasupplier;

import com.utils.zerocell.TestDataExcel;
import io.github.sskorol.core.DataSupplier;
import io.github.sskorol.data.XlsxReader;
import one.util.streamex.StreamEx;
import org.testng.annotations.Test;

import static io.github.sskorol.data.TestDataReader.use;

import java.lang.reflect.Method;

public class UseCaseTest3 {


    @Test(dataProvider = "getTestDataFromExcel")
    public void testDataFromExcel(TestDataExcel testData1) {
        System.out.println(testData1);

    }

    @DataSupplier
    public StreamEx<TestDataExcel> getTestDataFromExcel(Method method) {
        return use(XlsxReader.class)
                .withTarget(TestDataExcel.class)
                .withSource("testdata.xlsx")
                .read();

    }
}
