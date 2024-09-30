package ex_21092024;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG008 {
    @Parameters("browser")
    @Test
    void demo1(String value){
        System.out.println("Browser is" +value);
    }

}
