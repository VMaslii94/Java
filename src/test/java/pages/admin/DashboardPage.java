package pages.admin;

import mentorship.core.EnvVars.EnvVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class DashboardPage extends BasePage {

    @FindBy(css = "p.serverHeader__title")
    private WebElement title;

    @FindBy(css = "#account a")
    private WebElement accountBtn;


    public DashboardPage(WebDriver webDriver){
        super(webDriver);
        new WebDriverWait(webDriver, EnvVars.WAIT_TIMEOUT)
                .until(ExpectedConditions.visibilityOf(title));
    }


    public String getTitle() {
        return title.getText();
    }

    public ProfilePage clickAccountBtn() {
        accountBtn.click();
        return new ProfilePage(webDriver);
    }
}
