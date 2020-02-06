package mentorship.browserInstanceTests;

import mentorship.core.browser.WebDriverProvider;
import mentorship.core.waiters.Waiters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class chromeBrowser {

    @Parameters("browserName")
    @Test
    public void createBrowser(@Optional("CHROME") String browserName) {
        WebDriver driver = WebDriverProvider.createDriver(browserName);
        Waiters.setImplicitTimeOut(driver);
        try {
            driver.get("https://www.youtube.com/watch?v=ms3NggvNW40&list=PLUDwpEzHYYLv9v8aRuNi67vZ81cW2ksze");
            // driver.findElement(By.id("ttttest"));
            System.out.println(driver.getTitle());
        } finally {
            driver.close();
        }
        System.out.println("first Methods chromeBrowser");
    }
}
