package tests.user;

import mentorship.core.browser.Browser;
import mentorship.core.browser.WebDriverProvider;
import mentorship.suitSetup.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.user.CommonUserPage;
import pages.user.LoginPage;
import pages.user.accountPage.AccountPage;
import pages.user.accountPage.ProfilePage;

import static org.testng.Assert.assertEquals;

public class AccountTest extends BaseTest {

    @Test
    public void accountTest() {
        WebDriver webDriver = WebDriverProvider.createDriver(Browser.CHROME.name());
        webDriver.get("https://www.phptravels.net");


        CommonUserPage commonUserPage = new CommonUserPage(webDriver);
       // commonUserPage.selectLanguage("Arabic");

        System.out.println("GIVEN: User with credentials");
        final String email = "user@phptravels.com";
        final String password = "demouser";

        AccountPage accountPage = new LoginPage(webDriver).login(email, password);

        System.out.println("WHEN: User  click on 'my profile' menu");
        accountPage.openMyProfileMenu();

        System.out.println("THEN:  Personal page is opened and displayed correct first name  ");
        ProfilePage profilePage = new ProfilePage(webDriver);
        profilePage.getTitle();
        assertEquals(profilePage.getFirstName(), "Demo", "Check first name in profile page");
        WebDriverProvider.quitDriver(webDriver);

    }
}
