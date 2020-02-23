package tests.admin;

import mentorship.core.browser.WebDriverProvider;
import mentorship.suitSetup.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.admin.DashboardPage;
import pages.admin.LoginPage;
import pages.admin.ProfilePage;

import static org.testng.Assert.assertEquals;


public class LoginTest extends BaseTest {


    @Test
    public void loginAsAdminPassed(){

        System.out.println("GIVEN: Login page of Admin is opened");
        WebDriver webDriver = WebDriverProvider.createDriver("chrome");
        webDriver.get("https://www.phptravels.net/admin");

        System.out.println("GIVEN: Admin User with credentials");
        final String email = "admin@phptravels.com";
        final String password = "demoadmin";

        System.out.println("WHEN: Admin User enters credentials and click login button");
        DashboardPage dashboardPage = new LoginPage(webDriver)
                .setEmail(email)
                .setPassword(password)
                .clickLoginBtn();

        System.out.println("THEN: Admin User should be logged. Dashboard is opened");
        assertEquals(dashboardPage.getTitle(), "DASHBOARD", "Page Title");

        System.out.println("WHEN: Admin User account button");
        ProfilePage profilePage = dashboardPage.clickAccountBtn();

        System.out.println("THEN: Profile is opened. Users email is correct");
        assertEquals(profilePage.getEmail(), email, "Email");

    }
}
