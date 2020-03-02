package tests.admin;

import mentorship.constants.CONSTANTS;
import mentorship.core.browser.WebDriverProvider;
import mentorship.suitSetup.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.admin.DashboardPage;
import pages.admin.LoginPage;
import pages.admin.SettingsPage;

public class GeneralSettingTest extends BaseTest {


    @Test
    public void setMultipleLanguage() {

        System.out.println("GIVEN: Login page of Admin is opened");
        WebDriver webDriver = WebDriverProvider.createDriver("chrome");
        webDriver.get("https://www.phptravels.net/admin");

        System.out.println("GIVEN: Admin User with credentials");
        CONSTANTS.setConstantInHashMap("email","admin@phptravels.com");

        final String email = CONSTANTS.getFromHashMapByKey("email");// CONSTANTS.EMAIL;
        final String password = CONSTANTS.PASSWORD;

        System.out.println("WHEN: Admin User enters credentials and click login button");
        DashboardPage dashboardPage = new LoginPage(webDriver)
                .login(email, password);

        System.out.println("WHEN:Dashboard is opened and user click on setting btn in side bar");
        SettingsPage settingsPage = dashboardPage.sideBar.openGeneralMenu().clickOnSettings();

        System.out.println("GIVEN: Admin User with multiLanguage value");
        final String multiLanguageValue = "Disabled";

        System.out.println("THEN:Setting page is opened and user save chaged value for multi language field");
        settingsPage.setMultiLanguageField(multiLanguageValue).submitChanges();

        System.out.println("THEN:Setting page still opened and user validate value for multi language field");
        Assert.assertEquals(settingsPage.getSelectedMultiLanguageValue(), multiLanguageValue, "Validate multiLanguage value after editing");


        WebDriverProvider.quitDriver(webDriver);
    }
}