package pages.user;

import mentorship.core.browser.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends CommonUserPage {

    @FindBy(css = "p.serverHeader__title")
    private WebElement rootElement;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        CommonActions commonActions = new CommonActions(webDriver).waitForElementVisibility(rootElement);
    }
}
