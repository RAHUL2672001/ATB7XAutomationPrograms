package ex_26092024.POJOS;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class POJOLinked_Has_Map {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;// {
    Response response;//    "firstname" : "sally",
    String token;//    "lastname" : "brown",
    String bookingID;//    "totalprice" : 111,
    //    "depositpaid" : true,
    //    "bookingdates" : {
    //        "checkin" : "2018-01-01",
    //        "checkout" : "2019-01-01"
    //    },
    //    "additionalneeds" : "Breakfast"
    //}
    @Test
    public void test_post_with_hasmap() {
        Map<String,Object> josnmap= new LinkedHashMap<>();
        josnmap.put("firstname","sally");
        josnmap.put("lastname","brown");
        josnmap.put("totalPrice",111);
        josnmap.put("depositpaid",true);

        Map<String,Object> bookingdatesmap= new LinkedHashMap<>();
        bookingdatesmap.put("checkin","2018-01-01");
        bookingdatesmap.put("checkout","2019-01-01");

        josnmap.put("bookingdates",bookingdatesmap);
        josnmap.put("addtionalneeds","breakfast");

        System.out.println(josnmap);

         requestSpecification = RestAssured.given();
         requestSpecification.baseUri("https://restful-booker.herokuapp.com");
         requestSpecification.basePath("/booking/");
         requestSpecification.contentType(ContentType.JSON);
         requestSpecification. body(josnmap).log().all();
         Response response = requestSpecification.when().post();
}
  }              // Get Validatable response to perfworm validation