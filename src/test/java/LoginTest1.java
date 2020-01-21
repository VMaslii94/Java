import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest1 {

    @Test
    void loginTest() {
        //System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.youtube.com");
        System.out.println(driver.getTitle());
//                 driver.close();
    }
    @BeforeTest
   void before (){
        System.out.println("tttt");
    }
}
