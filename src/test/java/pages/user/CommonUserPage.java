package pages.user;

import mentorship.core.browser.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
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
        CommonActions commonActions = new CommonActions(webDriver).waitForElementVisibility(navigationTabs );
    }


    public CommonUserPage selectLanguage (String languageName){

        WebElement language_dropdown=webDriver.findElement(By.cssSelector(".dropdown-language .dropdown-menu-inner"));

        Select language=new Select(language_dropdown);

        language.selectByValue(languageName);
        WebElement first_value=language.getFirstSelectedOption();
        String value=first_value.getText();
        System.out.println("sss"+ value);
        return  this;
    }

    public LoginPage openLoginPage(){
        myAccountDropDown.click();
        commonActions.waitForElementVisibility(loginIcon);
        loginIcon.click();
        System.out.println("Opened login page");
        return new LoginPage(webDriver);
    }

    public void openHomePage(){
        homeTab.click();
        System.out.println("Opened home page");
    }


}
