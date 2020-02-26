package pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class ProfilePage extends BasePage {

    @FindBy(css = "[name=email]")
    private WebElement emailInp;


    public ProfilePage(WebDriver webDriver){
        super(webDriver);
       commonActions.waitForElementVisibility(emailInp);
    }


    public String getEmail() {
        return emailInp.getAttribute("value");
    }
}
