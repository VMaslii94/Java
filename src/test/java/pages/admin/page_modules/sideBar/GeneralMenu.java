package pages.admin.page_modules.sideBar;

import mentorship.core.browser.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.admin.SettingsPage;

public class GeneralMenu extends SideBar {

    WebDriver webDriver;
    CommonActions commonActions;

    @FindBy(css = "a[href=\"#menu-ui\"]")
    private WebElement rootElement;

    @FindBy(css = "a[href=\"https://www.phptravels.net/admin/settings/\"]")
    private WebElement settingSubTabInGeneralTab;


    public GeneralMenu(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        this.commonActions = new CommonActions(webDriver);
        commonActions.waitForElementVisibility(rootElement);
        PageFactory.initElements(webDriver, this);

    }

    public SettingsPage clickOnSettings() {
        rootElement.click();
        commonActions.waitForElementVisibility(settingSubTabInGeneralTab);
        settingSubTabInGeneralTab.click();
        return new SettingsPage(webDriver);
    }
}
