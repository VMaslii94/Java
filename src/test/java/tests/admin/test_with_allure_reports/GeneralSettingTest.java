package tests.admin.test_with_allure_reports;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import mentorship.constants.CONSTANTS;
import mentorship.core.browser.WebDriverProvider;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.admin.DashboardPage;
import pages.admin.LoginPage;
import pages.admin.SettingsPage;

import java.io.IOException;

import static io.qameta.allure.Allure.description;

public class GeneralSettingTest {

    @Severity(SeverityLevel.NORMAL)
    @Test
    public void setMultipleLanguage() throws IOException, ParseException {
        description("GeneralSettingTest");

        System.out.println("GIVEN: Login page of Admin is opened");
        WebDriver webDriver = WebDriverProvider.createDriver("chrome");
        webDriver.get("https://www.phptravels.net/admin");

        System.out.println("GIVEN: Admin User with credentials");
        CONSTANTS.setConstantInHashMap("email", "admin@phptravels.com");

        final String email = CONSTANTS.getFromHashMapByKey("email");// CONSTANTS.EMAIL;
        final String password = CONSTANTS.PASSWORD;

        System.out.println("WHEN: Admin User enters credentials and click login button");
        DashboardPage dashboardPage = new LoginPage(webDriver)
                .login(email, password);


        System.out.println("WHEN:Dashboard is opened and user click on setting btn in side bar");
        SettingsPage settingsPage = dashboardPage.sideBar.openGeneralSubMenu().generalSubMenu.clickOnSettings();

        System.out.println("GIVEN: Admin User with multiLanguage value");
        final String multiLanguageValue = "Disabled";

        System.out.println("THEN:Setting page is opened and user save chaged value for multi language field");
        settingsPage.setMultiLanguageField(multiLanguageValue).submitChanges();

//        AllureReport allureReport= new AllureReport(webDriver);
//        allureReport.addTextIntoReport("GoogleText");
//       addAttachment("rrr","application/json", new String(Files.readAllBytes(Paths.get("/Users/vladmaslii/IdeaProjects/TestingProject/src/test/resources/files/Allure_JSON.json")))  );
//       // attachment("ttest1", JSONParser."/Users/vladmaslii/IdeaProjects/TestingProject/src/test/resources/files/Allure_JSON.json");

        System.out.println("THEN:Setting page still opened and user validate value for multi language field");
        Assert.assertEquals(settingsPage.getSelectedMultiLanguageValue(), multiLanguageValue, "Validate multiLanguage value after editing");


        WebDriverProvider.quitDriver(webDriver);
    }

}