package pages.admin.page_modules.sideBar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class SideBar extends BasePage {

    @FindBy(css = "a[href=\"#menu-ui\"]")
    private WebElement generalMenu;

    @FindBy(css = "a[href=\"#ACCOUNTS\"]")
    private WebElement accountMenu;


    public GeneralSubMenu generalSubMenu;
    public AccountSubMenu accountSubMenu;

    public SideBar(WebDriver webDriver) {
        super(webDriver);
        commonActions.waitForElementVisibility(generalMenu);
        PageFactory.initElements(webDriver, this);


    }

    public SideBar openGeneralSubMenu() {
        commonActions.waitForElementVisibility(generalMenu);
        generalMenu.click();
        generalSubMenu = new GeneralSubMenu(webDriver);
        return this;
    }

    public SideBar openAccountSubMenu() {
        commonActions.waitForElementVisibility(accountMenu);
        accountMenu.click();
        accountSubMenu = new AccountSubMenu(webDriver);
        return this;
    }

}