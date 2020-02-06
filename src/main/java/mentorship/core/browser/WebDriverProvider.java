package mentorship.core.browser;

import mentorship.core.EnvVars.EnvVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverProvider {

    public static WebDriver createDriver(String browserName) {
        WebDriver webDriver;

        if (browserName.equals(Browser.CHROME.name())) {
            System.setProperty("webdriver.chrome.driver", EnvVars.CHROME_DRIVER_PATH);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("window-size=1400,900");
            options.addArguments("incognito");
            if (EnvVars.HEADLESS) {
                options.addArguments("--headless");
            }
            // options.addArguments("--ignore-certificate-errors");
            // options.addArguments("--disable-gpu");
            webDriver = new ChromeDriver(options);

        } else if (browserName.equals(Browser.FF.name())) {
            //  System.setProperty("webdriver.firefox.bin", "/usr/lib/firefox/firefox");
            System.setProperty("webdriver.gecko.driver", EnvVars.FIREFOX_DRIVER_PATH);
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("window-size=1920,1200");
            options.addArguments("-private-window");
            if (EnvVars.HEADLESS) {
                options.setHeadless(true);
            }
            webDriver = new FirefoxDriver(options);


//            // For use with RemoteWebDriver:
//            RemoteWebDriver driver = new RemoteWebDriver(
//                    new URL("http://localhost:4444/wd/hub"),
//                    new ChromeOptions());

        } else {
            throw new RuntimeException("Incorrect browser name : " + browserName);
        }
        return webDriver;

    }


}
