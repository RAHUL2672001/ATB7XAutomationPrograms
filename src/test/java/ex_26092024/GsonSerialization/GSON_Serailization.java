package ex_26092024.GsonSerialization;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class GSON_Serailization {

    RequestSpecification r = RestAssured.given();
    Response response;
    ValidatableResponse validatableResponse;
    @Test
     public void testNonBDDstylepostPositive(){
         Booking booking= new Booking();
         booking.setFirstname("James");
         booking.setLastname("Brown");
         booking.setTotalprice(111);
         booking.setDepositpaid(true);

         BookingsDates bookingsDates= new BookingsDates();
         bookingsDates.setCheckin("2024-02-01");
         bookingsDates.setCheckout("2024-02-01");

         booking.setBookingsDates(bookingsDates);
         booking.setAdditionalneeds("Breakfast");

         System.out.println(booking);

         //java object ->JSON String (bytestream)- Serialization

        Gson gson=new Gson();
        String jsonstringPayload = gson.toJson(booking);
        System.out.println(jsonstringPayload);


//            String BASE_URL = "https://restful-booker.herokuapp.com";
//            String BASE_PATH = "/booking";

            r.baseUri("https://restful-booker.herokuapp.com");
            r.basePath("/booking");
            r.contentType(ContentType.JSON).log().all();
            r.body(jsonstringPayload);

            response = r.when().log().all().post();
            String responseString = response.asString();
            System.out.println(responseString);


            validatableResponse = response.then().log().all();
            validatableResponse.statusCode(200);



       // Parse - DeSerialization
        Bookingresponse bookingresponse= gson.fromJson(responseString,Bookingresponse.class);
        System.out.println(bookingresponse.getBookingID());
        System.out.println();
    }
}








