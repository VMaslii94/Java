package mentorship.browserInstanceTests;

import mentorship.core.browser.WebDriverProvider;
import mentorship.core.waiters.Waiters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class firefoxBrowser {
    @Parameters("browserName")
    @Test
    public void createBrowser(@Optional("FF") String browserName) {
        WebDriver driver = WebDriverProvider.createDriver(browserName);

        try {
            driver.get("https://www.youtube.com/watch?v=ms3NggvNW40&list=PLUDwpEzHYYLv9v8aRuNi67vZ81cW2ksze");
            Waiters.visibilityOfElementExplicitTimeOut(driver, "search-icon-legacy");
            System.out.println(driver.getTitle());
        } finally {
            driver.quit();
        }

        System.out.println("first Methods in firefoxBrowser");
    }
}
