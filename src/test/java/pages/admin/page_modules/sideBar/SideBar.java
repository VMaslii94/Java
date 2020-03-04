package pages.admin.page_modules.sideBar;

import mentorship.core.browser.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class SideBar extends BasePage {

    WebDriver webDriver;
    CommonActions commonActions;

    @FindBy(css = "a[href=\"#menu-ui\"]")
    private WebElement generalMenu;

    @FindBy(css = "a[href=\"https://www.phptravels.net/admin/settings/\"]")
    private WebElement settingSubTabInGeneralTab;


    public SideBar(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        this.commonActions = new CommonActions(webDriver);
        commonActions.waitForElementVisibility(generalMenu);
        PageFactory.initElements(webDriver, this);


    }

    public GeneralSubMenu openGeneralSubMenu() {
        return new GeneralSubMenu(webDriver);
    }

    public AccountSubMenu openAccountSubMenu() {
        return new AccountSubMenu(webDriver);
    }

}