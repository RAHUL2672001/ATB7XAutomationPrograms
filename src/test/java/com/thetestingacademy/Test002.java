package com.thetestingacademy;

import io.restassured.RestAssured;

public class Test002 {
    public static void main(String[] args) {
        System.out.println("Rest Assured Test Case");
        System.out.println("Get Request Demo");

        //Gherkins syntax
        //GIVEN()= URL,HEADERS,BODY AND PAYLOAD
        //WHEN() = HTTPS METHODS - GET,POST,PATCH,PUT,DELETE
        //THEN() = VERIFY THE RESPONSE ER ==AR

        RestAssured
                .given()
                      .baseUri("https://restful-booker.herokuapp.com")
                      .basePath("/booking/211").log().all()
                .when()
                      .get()
                .then().log().all()
                      .statusCode(200);
    }

}
