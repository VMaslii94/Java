package tests.user;

import mentorship.core.browser.Browser;
import mentorship.core.browser.CommonActions;
import mentorship.core.browser.WebDriverProvider;
import mentorship.suitSetup.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.user.CommonUserPage;
import pages.user.LoginPage;
import pages.user.accountPage.AccountPage;
import pages.user.accountPage.ProfilePage;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {


    @Test
    public void loginTest() {


        WebDriver webDriver = WebDriverProvider.createDriver(Browser.CHROME.name());

        webDriver.get("https://www.phptravels.net");
        CommonUserPage commonUserPage = new CommonUserPage(webDriver);
        commonUserPage.openLoginPage();

        System.out.println("GIVEN: User with credentials");
        final String email = "user@phptravels.com";
        final String password = "demouser";


        System.out.println("WHEN: User populate credentials and click on login btn");
        AccountPage accountPage = new LoginPage(webDriver)
                .setEmail(email)
                .setPassword(password)
                .clickLoginBtn();
        CommonActions.checkIfElementExistCssSelector(webDriver, "nav.main-nav-menu");

        System.out.println("THEN:  User should be logged. Dashboard is opened");
        assertEquals(accountPage.getProfileName(), "Hi, Demo User", "Check user name in account page");

        System.out.println("WHEN: User  click on 'my profile' menu");
        accountPage.openMyProfileMenu();

        System.out.println("THEN:  Personal page is opened and displayed correct first name  ");
        ProfilePage profilePage = new ProfilePage(webDriver);
        profilePage.getTitle();
        assertEquals(profilePage.getFirstName(), "Demo", "Check first name in profile page");
        WebDriverProvider.quitDriver(webDriver);

    }


}
