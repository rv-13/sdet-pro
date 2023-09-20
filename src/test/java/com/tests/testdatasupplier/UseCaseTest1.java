package com.tests.testdatasupplier;

import io.github.sskorol.core.DataSupplier;
import org.testng.annotations.Test;

import java.util.stream.Stream;

public class UseCaseTest1 {

    @Test(dataProvider = "getData")
    public void testDemo(int a, int b, int c) {
        System.out.println(a);
    }

    //    @DataSupplier(indices = {0, 1})
    @DataSupplier(transpose = true)
    public Stream<Integer> getData() {
        return Stream.of(1, 2, 3);
    }
}
