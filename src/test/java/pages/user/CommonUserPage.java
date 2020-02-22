package pages.user;

import mentorship.core.browser.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class CommonUserPage extends BasePage {

    @FindBy(css = "nav.main-nav-menu")
    private WebElement navigationTabs;

    @FindBy(css = "blabla")
    private WebElement homeTab;

    @FindBy(css = "li>div.dropdown-login")
    private WebElement myAccountDropDown;

    @FindBy(css = "a[href=\"https://www.phptravels.net/login\"]")
    private WebElement loginIcon;

    public CommonUserPage(WebDriver webDriver){
        super(webDriver);
        CommonActions.waitForElementVisibility(webDriver, navigationTabs );
    }


    public LoginPage openLoginPage(){
        myAccountDropDown.click();
        CommonActions.waitForElementVisibility(webDriver,loginIcon);
        loginIcon.click();
        System.out.println("Opened login page");
        return new LoginPage(webDriver);
    }

    public void openHomePage(){
        homeTab.click();
        System.out.println("Opened home page");
    }


}
