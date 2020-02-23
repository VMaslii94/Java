package pages.admin;

import mentorship.core.browser.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class LoginPage extends BasePage {

    @FindBy(css = "form.form-signin")
    private WebElement rootElement;

    @FindBy(css = "input[name=email]")
    private WebElement emailInp;

    @FindBy(css = "input[name='password']")
    private WebElement passwordInp;

    @FindBy(css = "button.btn-lg")
    private WebElement loginBtn;


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        CommonActions commonActions = new CommonActions(webDriver).waitForElementVisibility(rootElement);
//        new WebDriverWait(webDriver, EnvVars.WAIT_TIMEOUT)
//                .until(ExpectedConditions.visibilityOf(rootElement));
    }


    public LoginPage setEmail(String email) {
        emailInp.sendKeys(email);
        return this;
    }

    public LoginPage setPassword(String password) {
        passwordInp.sendKeys(password);
        return this;
    }

    public DashboardPage clickLoginBtn() {
        loginBtn.click();
        return new DashboardPage(webDriver);
    }



}
