package mentorship.TestNGTests;

import mentorship.core.EnvVars.EnvVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

public class TestSuitParameters extends EnvVars {
    public WebDriver driver;

    @BeforeSuite
    public void before() {

        System.out.println("Before all classes");
    }

    @AfterSuite
    public void after() {
        System.out.println("After all");
    }


    @Parameters("browser")
    @BeforeClass
    public void setBrowserInstance(String browser) {

        if (browser.equalsIgnoreCase("firefox")) {
            //create firefox instance
            driver = new FirefoxDriver();

        }
        //Check if parameter passed as 'chrome'
        else if (browser.equalsIgnoreCase("chrome")) {

            //create chrome instance
            driver = new ChromeDriver();

        }
    }


    @BeforeMethod
    public void beforeMethod(ITestContext context) {
        context.getCurrentXmlTest().getTestParameters().forEach((key, value) -> {
            System.out.println("key : " + key + "  and value : " + value);
        });
    }


}
