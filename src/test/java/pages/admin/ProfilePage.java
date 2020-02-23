package pages.admin;

import mentorship.core.EnvVars.EnvVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class ProfilePage extends BasePage {

    @FindBy(css = "[name=email]")
    private WebElement emailInp;


    public ProfilePage(WebDriver webDriver){
        super(webDriver);
        new WebDriverWait(webDriver, EnvVars.WAIT_TIMEOUT)
                .until(ExpectedConditions.visibilityOf(emailInp));
    }


    public String getEmail() {
        return emailInp.getAttribute("value");
    }
}
