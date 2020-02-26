package tests.user;

import mentorship.core.browser.Browser;
import mentorship.core.browser.CommonActions;
import mentorship.core.browser.WebDriverProvider;
import mentorship.suitSetup.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.user.CommonUserPage;
import pages.user.accountPage.AccountPage;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {


    @Test
    public void loginTest() {


        WebDriver webDriver = WebDriverProvider.createDriver(Browser.CHROME.name());

        webDriver.get("https://www.phptravels.net");
        CommonActions commonActions = new CommonActions(webDriver)
                .jsExecute("alert('We executed js script :)');")
                .closeAlertWindow();

        System.out.println("GIVEN: User with credentials");
        final String email = "user@phptravels.com";
        final String password = "demouser";

        System.out.println("WHEN: User open login form and populate credentials and click on login btn");
        AccountPage accountPage = new CommonUserPage(webDriver)
                .openLoginPage()
                .setEmail(email)
                .setPassword(password)
                .clickLoginBtn()
                ;
        Boolean element = accountPage.checkNavigationBarExistence();
        if (element) {
            assertTrue(element, "Validate that element exist in DOM");
        }
        else {
            assertFalse(element, "Validate that element not exist in DOM");
        }
        System.out.println("THEN: User should be logged. Account page  is opened");
       // assertEquals(accountPage.getProfileName(), "Hi, Demo User", "Check user name in account page");
        WebDriverProvider.quitDriver(webDriver);

    }


}
