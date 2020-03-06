package pages.admin.page_modules.sideBar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.admin.SettingsPage;

public class GeneralSubMenu extends BasePage {

    @FindBy(css = "a[href=\"#menu-ui\"]")
    private WebElement rootElement;

    @FindBy(css = "a[href=\"https://www.phptravels.net/admin/settings/\"]")
    private WebElement settingSubTabInGeneralTab;


    public GeneralSubMenu(WebDriver webDriver) {
        super(webDriver);
        commonActions.waitForElementVisibility(rootElement);
        PageFactory.initElements(webDriver, this);

    }

    public SettingsPage clickOnSettings() {
        commonActions.waitForElementVisibility(rootElement);
        rootElement.click();
        commonActions.waitForElementVisibility(settingSubTabInGeneralTab);
        settingSubTabInGeneralTab.click();
        return new SettingsPage(webDriver);
    }
}
