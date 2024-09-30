package ex_21092024.CRUD;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class TestCaseIntegration {

    //Create a Token
    //Create a Booking
    //Perform a PUT request
    //Verify that PUT is success by GET Request
    //Delete the ID
    //Verify it doesn't exist GET Request
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    String bookingID;

    public String getToken() {

        String payload = "{\n" +
                "                    \"username\" : \"admin\",\n" +
                "                    \"password\" : \"password123\"\n" +
                "                }";

        //Given - Request Specification.
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON).log().all();
        r.body(payload);

        //When - Response.
        Response response = r.when().post();


        //Then - Validatable Response.
        //validation
        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(200);
        //Extract The token
        token = response.jsonPath().getString("token");
        System.out.println(token);
        return token;

    }

    public String getBookingID() {
        String payload = "{\n" +
                "    \"firstname\" : \"rahul\",\n" +
                "    \"lastname\" : \"Dutta\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2028-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload).log().all();


        Response response = requestSpecification.when().post();

        // Get Validatable response to perform validation

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        bookingID = response.jsonPath().getString(" bookingid");
        return bookingID;


    }

    @Test(priority = 0)
    public void test_update_request_put() {

        token = getToken();
        bookingID = getBookingID();

        String payloadPUT = "{\n" +
                "    \"firstname\" : \"rahul\",\n" +
                "    \"lastname\" : \"Ji\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";


        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/" + bookingID);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);
        requestSpecification.body(payloadPUT).log().all();

        Response response = requestSpecification.when().put();


        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
    }

    @Test(priority = 1)
    public void test_update_request_get() {

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/" + bookingID).log().all();

        response = requestSpecification.when().get();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        Assert.assertEquals(response.then().extract().path("firstname"), "rahul");
        Assert.assertEquals(response.then().extract().path("lastname"), "Ji");

    }


    @Test(priority = 2)
    public void test_delete_booking() {
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/booking");
        requestSpecification.basePath("/" + bookingID);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token).log().all();

        response = requestSpecification.when().delete();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);

    }


    @Test(priority = 3)
    public void test_after_delete_request_get() {

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/booking");
        requestSpecification.basePath("/" + bookingID).log().all();

        response = requestSpecification.when().get();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(404);

        Assert.assertEquals(response.then().extract().statusCode(), 404);

    }
}




