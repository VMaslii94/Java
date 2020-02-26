package pages.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends CommonUserPage {

    @FindBy(css = "p.serverHeader__title")
    private WebElement rootElement;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        commonActions.waitForElementVisibility(rootElement);
    }
}
