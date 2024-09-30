package ex_21092024.CRUD;
import static org.assertj.core.api.Assertions.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TestNG011_assertions {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    Integer bookingID;
@Test
    public void test_post() {
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

        //Rest Assured Default- Hamcrest
        //import org.Matchers
//        validatableResponse.body("booking.firstname", Matchers.equalTo("rahul"));
//        validatableResponse.body("bookingid", Matchers.notNullValue());

       //TestNG Assertion
      //soft assertvs
     //hard assert
      bookingID=response.then().extract().path("bookingid");
      String firstname= response.then().extract().path("booking.firstname");

//    Assert.assertNotNull(bookingID);
//    Assert.assertEquals(firstname,"rahul");


    //AssertJ Asserrtion
    assertThat(bookingID).isNotNull().isPositive().isNotZero();
    assertThat(firstname).isEqualTo("rahul").isNotEmpty().isNotBlank();



    }
}

