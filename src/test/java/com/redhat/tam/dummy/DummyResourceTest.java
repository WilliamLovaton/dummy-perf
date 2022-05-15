package com.redhat.tam.dummy;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class DummyResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/dummy")
          .then()
             .statusCode(200)
             .body(is("Hello RESTEasy"));
    }

}