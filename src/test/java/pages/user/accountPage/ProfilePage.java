package pages.user.accountPage;

import mentorship.core.browser.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends AccountPage {
    @FindBy(css = ".content-wrapper>.heading-title")
    private WebElement rootElement;
    @FindBy(css = "input[name=\"firstname\"]")
    private WebElement firstName;


    public ProfilePage(WebDriver webDriver) {
        super(webDriver);
        CommonActions commonActions = new CommonActions(webDriver).waitForElementVisibility(rootElement);
    }

    public String getTitle() {
        System.out.println("Title of Profile Page  is : " + rootElement.getText());
        return rootElement.getText();

    }

    public String getFirstName() {
        System.out.println("First name value is : " + firstName.getAttribute("value"));
        return firstName.getAttribute("value");
    }

}
