package TestNGTests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestSuitParameters {

    @BeforeSuite
    public void before(){
        System.out.println("Before all classes");
    }
    @AfterSuite
    public void after (){
        System.out.println("After all");
    }

}
