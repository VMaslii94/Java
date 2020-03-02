package pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.admin.page_modules.sideBar.SideBar;

public class ProfilePage extends BasePage {

    @FindBy(css = "[name=email]")
    private WebElement emailInp;

    public SideBar sideBar;
    public ProfilePage(WebDriver webDriver){
        super(webDriver);
        this.sideBar = new SideBar(webDriver);
       commonActions.waitForElementVisibility(emailInp);
    }


    public String getEmail() {
        return emailInp.getAttribute("value");
    }
}
