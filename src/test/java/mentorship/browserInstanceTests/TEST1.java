package mentorship.browserInstanceTests;

import mentorship.TestNGTests.TestSuitParameters;
import org.testng.annotations.Test;

public class TEST1 extends TestSuitParameters {

    @Test
    void loginTest() {

        driver.get("https://www.youtube.com/watch?v=ms3NggvNW40&list=PLUDwpEzHYYLv9v8aRuNi67vZ81cW2ksze");
        System.out.println(driver.getTitle());
        driver.close();

        System.out.println("first Methods");

    }
}
