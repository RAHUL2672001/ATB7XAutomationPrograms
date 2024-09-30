package GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class NonBDDStyle {
    static RequestSpecification r = RestAssured.given();

    public static void main(String[] args) {
        r.baseUri("https://api.zippopotam.us");
        testnon_bdd_1();
        testnon_bdd_2();

    }
    private static void testnon_bdd_2(){

        r.basePath("/IN/110005");
        r.when().get();
        r.then().log().all().statusCode(200);

    }
        private static void testnon_bdd_1(){
        r.basePath("/IN/110084");
        r.when().get();
        r.then().log().all().statusCode(200);
    }


}
