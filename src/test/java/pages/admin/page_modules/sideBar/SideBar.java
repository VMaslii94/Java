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
    GeneralMenu generalMenu;

    @FindBy(css = "div .social-sidebar")
    private WebElement rootElement;

    @FindBy(css = "a[href=\"https://www.phptravels.net/admin/settings/\"]")
    private WebElement settingSubTabInGeneralTab;


    public SideBar(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        this.commonActions = new CommonActions(webDriver);
        commonActions.waitForElementVisibility(rootElement);
        PageFactory.initElements(webDriver, this);


    }

    public GeneralMenu openGeneralMenu() {
        return new GeneralMenu(webDriver);
    }

    public AccountMenu openAccountsMenu() {
        return new AccountMenu(webDriver);
    }
//    public SettingsPage goToSettingInGeneral() {
//        generalTab.click();
//        settingSubTabInGeneralTab.click();
//
//
//        return new SettingsPage(webDriver);
//    }
}
