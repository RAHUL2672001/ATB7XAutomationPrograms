package testing;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class test001ng {

    @Test
    public void test_get(){

        RestAssured
                .given()
                .baseUri("http://api.zippopotam.us")
                .basePath("/IN/110084")
                .when()
                .log().all().get()
                .then()
                .log().all().statusCode(200);

    }
}
