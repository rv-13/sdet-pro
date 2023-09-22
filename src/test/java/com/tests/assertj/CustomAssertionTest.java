package com.tests.assertj;

import com.utils.assertj.entity.Posts;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CustomAssertionTest {

    @Test
    public void test() {
        Posts posts = Posts.builder().id(24).title("MrX").author("ravi").build();

        Response response = given()
                .contentType(ContentType.JSON)
                .log()
                .all()
                .body(posts)
                .post("http://localhost:3000/posts");

        response.prettyPrint();
        Posts reponsePosts = response.as(Posts.class);

        //COnventional way
//        Assert.assertEquals(response.getStatusCode(), 201);
//        Assert.assertTrue(response.header("Content-Type").contains("application/json"));
//        Assert.assertEquals(response.jsonPath().getInt("id"), 20);
//        Assert.assertEquals(response.jsonPath().getString("title"), "MrX");

        //AssertJ custom assertions / multiple class wise assertion , with chaining
        ResponseAssert.assertThat(response)
                .isSuccessfulPostResponse()
                .havingHeaderApplicationJsonType();
        //class / api specific assertions
        PostAsserts.assertThat(reponsePosts)
                .hasId(23);

    }
}
