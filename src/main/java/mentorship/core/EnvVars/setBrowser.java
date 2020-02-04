package mentorship.core.EnvVars;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

public class setBrowser {


    @Parameters("browser")
    public  WebDriver setBrowserrr(String browser) {
        WebDriver driver = null;
        EnvVars param = new EnvVars();
        if (browser.equalsIgnoreCase("firefox")) {
            //create firefox instance
            driver = new FirefoxDriver();

        }
        //Check if parameter passed as 'chrome'
        else if (browser.equalsIgnoreCase("chrome")) {
            //set path to chromedriver.exe

            //create chrome instance
            driver = new ChromeDriver();

        }
        return driver;
    }
}
