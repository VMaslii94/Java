package tests.admin;

import mentorship.constants.CONSTANTS;
import mentorship.core.browser.WebDriverProvider;
import mentorship.suitSetup.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.admin.DashboardPage;
import pages.admin.LoginPage;
import pages.admin.customers.Customers.Customers;
import pages.admin.page_modules.sideBar.customersTable.TwentyFiveItems;

public class CustomerTableTest extends BaseTest {


    @Test
    public void viewCustomersTable() {

        System.out.println("GIVEN: Login page of Admin is opened");
        WebDriver webDriver = WebDriverProvider.createDriver("chrome");
        webDriver.get("https://www.phptravels.net/admin");

        System.out.println("GIVEN: Admin User with credentials");
        CONSTANTS.setConstantInHashMap("email","admin@phptravels.com");

        final String email = CONSTANTS.EMAIL;
        final String password = CONSTANTS.PASSWORD;

        System.out.println("WHEN: Admin User enters credentials and click login button");
        DashboardPage dashboardPage = new LoginPage(webDriver)
                .login(email, password);

        System.out.println("WHEN:Dashboard is opened and user click on customers btn in side bar");
        Customers customers = dashboardPage.sideBar.openAccountsMenu().clickOnCustomers();
        //  customers.clickAddBtn();
        System.out.println("Then:Customers table is opened and user change count of displaying to 25 items ");
        TwentyFiveItems twentyFiveItemsDisplaying = customers.changeViewOn25Items();
       // twentyFiveItemsDisplaying.clickPrintBtn();


      //  WebDriverProvider.quitDriver(webDriver);
    }
}