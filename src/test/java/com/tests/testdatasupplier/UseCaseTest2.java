package com.tests.testdatasupplier;

import com.utils.testdatasupplier.entity.User;
import io.github.sskorol.core.DataSupplier;
import io.github.sskorol.data.CsvReader;
import io.github.sskorol.data.JsonReader;
import one.util.streamex.StreamEx;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.github.sskorol.data.TestDataReader.use;

public class UseCaseTest2 {

    @Test(dataProvider = "getData")
    public void testDemo(User user) {
        System.out.println(user);
    }

    //    @DataSupplier(indices = {0, 1})

    //Supplying data using conventional Data provider
   /* @DataProvider
    public Object[] getData() throws IOException {
        List<User> userList = new
                ObjectMapper().readValue(new File(System.getProperty("user.dir") + "/src/test/resources/testData.json"),
                new TypeReference<List<User>>() {
                });
        return userList.toArray();
    }
*/
    //Read JSon file and supply data
/*    @DataSupplier
    public StreamEx<User> getData() throws IOException {
        return use(JsonReader.class)
                .withTarget(User.class)
                .withSource("testData.json")
                .read();
    }*/

    //Read CSV file and supply data  using StreamEx
    @DataSupplier
    public StreamEx<User> getData() throws IOException {
        return use(CsvReader.class)
                .withTarget(User.class)
                .withSource("testData.csv")
                .read().limit(1);

    }

}
