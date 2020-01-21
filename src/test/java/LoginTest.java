import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

public class LoginTest {

    @Test
    void loginTest() {
        //System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.youtube.com/watch?v=ms3NggvNW40&list=PLUDwpEzHYYLv9v8aRuNi67vZ81cW2ksze");
        System.out.println(driver.getTitle());
//                 driver.close();
    }
}
