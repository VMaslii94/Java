package pages.user;

import mentorship.core.browser.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.user.accountPage.AccountPage;

public class LoginPage extends CommonUserPage {

    @FindBy(css = ".row div.ph-30")
    private WebElement rootElement;

    @FindBy(css = "input[name=username]")
    private WebElement emailInp;

    @FindBy(css = "input[name='password']")
    private WebElement passwordInp;

    @FindBy(css = "button.btn-lg")
    private WebElement loginBtn;


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        CommonActions commonActions = new CommonActions(webDriver).waitForElementVisibility(rootElement);

    }


    public LoginPage setEmail(String email) {
        emailInp.sendKeys(email);
        return this;
    }

    public LoginPage setPassword(String password) {
        passwordInp.sendKeys(password);
        return this;
    }

    public AccountPage clickLoginBtn() {
        loginBtn.click();
        return new AccountPage(webDriver);
    }
    public AccountPage login(String email, String password){
        openLoginPage();
        setEmail(email);
        setPassword(password);
        clickLoginBtn();
        return  new AccountPage(webDriver);
    }
}
