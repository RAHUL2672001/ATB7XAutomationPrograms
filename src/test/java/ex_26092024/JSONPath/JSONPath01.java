package ex_26092024.JSONPath;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JSONPath01 {
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

        System.out.println(response.asString());

        JsonPath jsonPath= new JsonPath(response.asString());
        String bookingID = jsonPath.getString("bookingid");
        String firstname = jsonPath.getString("booking.firstname");
        String checkout = jsonPath.getString("booking.bookingdates.checkout");
        System.out.println(bookingID);
        System.out.println(firstname);
        System.out.println(checkout);

        assertThat(bookingID).isNotNull().isNotBlank();
        assertThat(firstname).isNotNull().isEqualTo("rahul");

        
    }
}
