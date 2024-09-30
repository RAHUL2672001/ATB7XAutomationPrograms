package PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NonBDDPutStyle {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    //6118 bid
    //token
    //payload 1234567891011
    //{
    //{
    //    "firstname" : "Pramod",
    //    "lastname" : "Brown",
    //    "totalprice" : 111,
    //    "depositpaid" : true,
    //    "bookingdates" : {
    //        "checkin" : "2018-01-01",
    //        "checkout" : "2019-01-01"
    //    },
    //    "additionalneeds" : "Breakfast"

    // POST - AUTH - TOKEN
    //POST BOOKING ID
    //PUT - TOKEN AND BOOKING ID

    String payloadPUT= "{\n" +
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

@Test
public void test_put_positive_tc(){

    String token = "a723723974a741a";
    String Bookingid="140";

    requestSpecification = RestAssured.given();
    requestSpecification.baseUri("https://restful-booker.herokuapp.com");
    requestSpecification.basePath("/booking/"+Bookingid);
    requestSpecification.contentType(ContentType.JSON);
    requestSpecification.cookie("token",token);
    requestSpecification.body(payloadPUT).log().all();


    Response response = requestSpecification.when().put();

    // Get Validatable response to perform validation

    validatableResponse= response.then().log().all();
    validatableResponse.statusCode(200);





}



}
