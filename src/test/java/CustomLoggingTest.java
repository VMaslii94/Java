import jdk.nashorn.internal.ir.annotations.Ignore;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CustomLoggingTest extends TestSuitParameters {
 private static final String firstGroup = "first";
 private static final String secondGroup = "second";

    @Test(priority = 1, groups = {firstGroup})
    public void testMethodOne() {
        Assert.assertTrue(true);
    }

    @Test(groups = {firstGroup})
    public void testMethodTwo() {
        Assert.assertTrue(false);
    }

    @Test(dependsOnMethods = {"testMethodTwo"}, groups = {firstGroup})
    public void testMethodThree() {
        Reporter.log("Second valid method");
        Assert.assertTrue(true);
    }

    @Test(enabled = true)

    private void MethodFour() {
        Assert.assertTrue(false);
    }


    @Test(enabled = true)
    private void MethodFive() {
        Assert.assertTrue(true);
    }

    @Test(groups = {firstGroup,secondGroup} )
    private void MethodSix() {
        Reporter.log("Added assertion for method");
        Assert.assertTrue(true);
        Reporter.log("Added assertion2 for method");
        Assert.assertTrue(false);
        Reporter.log("Added assertion3 for method");
        Assert.assertTrue(true);
    }


    @Ignore
    @Test( groups ="bb", dependsOnGroups = {firstGroup})
    private void MethodSeven() {
        Assert.assertTrue(true);
    }

    @BeforeClass

    private void CreateSomeData(){
        System.out.println("Before this class");
    }

}
