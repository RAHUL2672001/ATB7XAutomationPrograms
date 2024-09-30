package ex_21092024;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG003 {
    String token;
    Integer bookingID;

    public String getToken(){
        token = "123";
        return token;
    }
    @BeforeTest
    public void getTokenandBookingID(){
        token= getToken();
        //POST Req
        //post code
        bookingID=123;
    }
    @Test
    public void testPUTReq1(){
        System.out.println(token);
        System.out.println(bookingID);
    }
    @Test
    public void testPUTReq2() {
        System.out.println(token);
        System.out.println(bookingID);
    }
    @Test
    public void testPUTReq3() {
        System.out.println(token);
        System.out.println(bookingID);
    }
}

