package pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import static io.qameta.allure.Allure.step;

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
        commonActions.waitForElementVisibility(rootElement);
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


    public DashboardPage login(String email, String password) {
//        description("LoginPageDescriptions");
        step("Login with userName : "+ email+" and password :"+password);
        setEmail(email);
        setPassword(password);
        allureReport.takeScreenshotIntoReport("When login page opened and populated login and password");
        clickLoginBtn();
        return  new DashboardPage(webDriver);
    }



}
