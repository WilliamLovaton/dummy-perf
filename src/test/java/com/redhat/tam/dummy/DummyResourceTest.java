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
             .body(is("Plese use any of these paths /dummy/fast, /dummy/slow-1, /dummy/slow-3, /dummy/slow-5 or /dummy/slow-10"));
    }

}
