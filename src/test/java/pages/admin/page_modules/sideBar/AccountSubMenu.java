package pages.admin.page_modules.sideBar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.admin.customerspage.CustomersPage;

public class AccountSubMenu extends BasePage {

    @FindBy(css = "a[href=\"#ACCOUNTS\"]")
    private WebElement rootElement;

    @FindBy(css = "a[href=\"https://www.phptravels.net/admin/accounts/customers/\"]")
    private WebElement customersSubTabInGeneralTab;


    public AccountSubMenu(WebDriver webDriver) {
        super(webDriver);
        commonActions.waitForElementVisibility(rootElement);
        PageFactory.initElements(webDriver, this);

    }

    public CustomersPage clickOnCustomers() {
        commonActions.waitForElementVisibility(customersSubTabInGeneralTab);
        customersSubTabInGeneralTab.click();
        return new CustomersPage(webDriver);
    }
}
