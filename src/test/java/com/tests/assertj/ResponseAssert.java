package com.tests.assertj;

import io.restassured.response.Response;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

public class ResponseAssert extends AbstractAssert<ResponseAssert, Response> {


    protected ResponseAssert(Response response, Class<?> selfType) {
        super(response, selfType);
    }

    //static method to returning constructor in the test class instead use of =constructor
    public static ResponseAssert assertThat(Response response) {
        return new ResponseAssert(response, ResponseAssert.class);
    }

    public ResponseAssert isSuccessfulPostResponse() { //whatever response will be coming as actual
        Assertions.assertThat(actual.getStatusCode())
                .withFailMessage(() -> "Status code is not 201")
                .isEqualTo(201)
                .isBetween(200, 204);
        return this;
    }

    public ResponseAssert havingHeaderApplicationJsonType() { //whatever response will be coming as actual
        Assertions.assertThat(actual.header("Content-Type"))
                .withFailMessage(() -> "Header is not AppJsonType")
                .contains("application/json");
        return this;
    }
}
