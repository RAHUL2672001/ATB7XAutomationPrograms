package ex_21092024;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG006 {

    @Test(groups = {"sanity","qa","preprod"})
    public void sanityRun(){
        System.out.println("sanity");
        System.out.println("qa");
        Assert.assertTrue(true);
    }
    @Test(groups = {"qa",})
    public void RegRun(){
        System.out.println("Reg");
        Assert.assertTrue(true);

    }
    @Test(groups = {"dev"})
    public void SmokeRun(){
        System.out.println("Smoke");
        Assert.assertTrue(true);

    }

}
