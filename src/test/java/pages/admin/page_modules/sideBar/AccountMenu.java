package pages.admin.page_modules.sideBar;

import mentorship.core.browser.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.admin.customers.Customers.Customers;

public class AccountMenu extends SideBar {

    WebDriver webDriver;
    CommonActions commonActions;

    @FindBy(css = "a[href=\"#ACCOUNTS\"]")
    private WebElement rootElement;

    @FindBy(css = "a[href=\"https://www.phptravels.net/admin/accounts/customers/\"]")
    private WebElement customersSubTabInGeneralTab;


    public AccountMenu(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        this.commonActions = new CommonActions(webDriver);
        commonActions.waitForElementVisibility(rootElement);
        PageFactory.initElements(webDriver, this);

    }

    public Customers clickOnCustomers() {
        rootElement.click();
        commonActions.waitForElementVisibility(customersSubTabInGeneralTab);
        customersSubTabInGeneralTab.click();
        return new Customers(webDriver);
    }
}
