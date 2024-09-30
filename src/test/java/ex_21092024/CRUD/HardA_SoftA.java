package ex_21092024.CRUD;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardA_SoftA {
//    @Test
//    public void HardAssertExample(){
//        Assert.assertTrue(false);//This will Throw AN assertion error and STATEMENT IS not executed.
//        System.out.println("This Line will Not BE Executed");
//    }
    @Test
    public void SoftAssertExample(){
        SoftAssert softAssert=new SoftAssert();
        System.out.println("This line will be executed");
        softAssert.assertAll(); //This will report all collected errors
    }



}
