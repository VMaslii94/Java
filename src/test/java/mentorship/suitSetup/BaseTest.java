package mentorship.suitSetup;

import mentorship.core.browser.WebDriverProvider;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    public void before() {

        System.out.println("Before all classes");
    }

    @AfterSuite
    public void after() {

        WebDriverProvider.quitAllDriver();
        System.out.println("After all");
    }


  @BeforeMethod
    public void beforeMethod(ITestContext context) {
        context.getCurrentXmlTest().getTestParameters().forEach((key, value) -> {
            System.out.println("key : " + key + "  and value : " + value);
        });
    }



}
