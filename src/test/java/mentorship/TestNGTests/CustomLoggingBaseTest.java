package mentorship.TestNGTests;

import jdk.nashorn.internal.ir.annotations.Ignore;
import mentorship.suitSetup.BaseTest;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CustomLoggingBaseTest extends BaseTest {
 private static final String firstGroup = "first";
 private static final String secondGroup = "second";

    @Test(priority = 1, groups = {firstGroup})
    public void testMethodOne() {
        Assert.assertTrue(true);
    }

    @Test(groups = {firstGroup})
    public void testMethodTwo() {
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = {"testMethodTwo"}, groups = {firstGroup})
    public void testMethodThree() {
        Reporter.log("Second valid method 11");
        Assert.assertTrue(true);
    }

    @Test(enabled = true)

    private void methodFour() {
        Assert.assertTrue(false);
    }


    @Test(enabled = true)
    private void methodFive() {
        Assert.assertTrue(true);
    }

    @Test(groups = {firstGroup,secondGroup} )
    private void methodSix() {
        Reporter.log("Added assertion for method");
        Assert.assertTrue(true);
        Reporter.log("Added assertion2 for method");
        Assert.assertTrue(true);
        Reporter.log("Added assertion3 for method");
        Assert.assertTrue(true);
    }


    @Ignore
    @Test( groups ="anotherGroup", dependsOnGroups = {firstGroup})
    private void methodSeven() {
        Assert.assertTrue(true);
    }

    @BeforeClass

    private void createSomeData(){
        System.out.println("Before this class");
    }

}
