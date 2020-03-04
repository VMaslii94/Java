package pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.admin.page_modules.sideBar.SideBar;

public class DashboardPage extends BasePage {

    @FindBy(css = "p.serverHeader__title")
    private WebElement title;

    @FindBy(css = "#account a")
    private WebElement accountBtn;

    public SideBar sideBar;

    public DashboardPage(WebDriver webDriver) {
        super(webDriver);
        commonActions.waitForElementVisibility(title);
        this.sideBar = new SideBar(webDriver);


    }

    public String getTitle() {
        return title.getText();
    }

    public ProfilePage clickAccountBtn() {
        accountBtn.click();
        return new ProfilePage(webDriver);
    }
}
