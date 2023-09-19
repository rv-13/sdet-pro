package com.tests.fixtures;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.utils.fixtures.Address;
import com.utils.fixtures.Employee;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PostEmployeeTest {


    @BeforeSuite
    public void setup() {
        FixtureFactoryLoader.loadTemplates("com.utils.templates");

    }

    @DataProvider(parallel = true)
    public static Object[][] dataProvide() {
        Employee valid = Fixture.from(Employee.class).gimme("valid");
        Employee invalid = Fixture.from(Employee.class).gimme("Invalid");
        Employee invalidfname = Fixture.from(Employee.class).gimme("Invalidfname");
        Address validAddress = Fixture.from(Address.class).gimme("validAddress");
        return new Object[][]{
                {valid, 201},
                {invalid, 201},
//                {invalid, 201},

        };
    }

    @Test(dataProvider = "dataProvide")
    public void postEmployeeTestUsingFixture(Employee employee, int statusCode) {
        Response response = given().contentType(ContentType.JSON)
                .log()
                .all()
                .body(employee)
                .post("http://localhost:3000/comments");

        Assert.assertEquals(response.getStatusCode(), statusCode);

    }
}
