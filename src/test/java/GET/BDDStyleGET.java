package GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class BDDStyleGET {
    public static void main(String[] args) {


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
