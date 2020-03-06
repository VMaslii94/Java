package pages.admin.customerspage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class CustomersPage extends BasePage {


    @FindBy(css = ".xcrud-list-container")
    private WebElement rootElement;

    @FindBy(css = "div .xcrud-overlay .matrialprogress")
    private WebElement progressBar;

    @FindBy(css = ".btn[data-limit='25']")
    private WebElement twentyFiveIcon;

    @FindBy(css = ".xcrud-nav a.xcrud-search-toggle")
    private WebElement searchIcon;

    @FindBy(css = ".add_button button.btn-success")
    private WebElement addBtn;

    @FindBy(css = "a[data-task=\"print\"]")
    private WebElement printIcon;

    public CustomersPage(WebDriver webDriver) {
        super(webDriver);

        commonActions.waitForElementVisibility(rootElement);
        PageFactory.initElements(webDriver, this);
    }

    public CustomersPage waitForProgressBar() {
        commonActions.waitForElementAppearAndDisappear(progressBar, 5);
        return this;
    }

    public CustomersPage changeViewOn25Items() {
        commonActions.waitForElementVisibility(twentyFiveIcon);
        commonActions.waitForCondition(el -> webDriver.findElements(By.cssSelector(".xcrud-list-container table tbody")).size() == 1, 15);
        //commonActions.jsExecute("window.scrollTo(0, document.body.scrollHeight)");;
        twentyFiveIcon.click();
//        String a = "document.querySelector(\"button[data-limit='25']\").click()";
//        commonActions.jsExecute("document.querySelector(\"button[data-limit='25']\").click()");
        waitForProgressBar();
        return this;
    }

    public void clickAddBtn() {
        commonActions.waitForElementVisibility(addBtn);
        addBtn.click();
        // TODO: add create customer form and return in this method
    }
    public CustomersPage clickPrintBtn(){
        commonActions.waitForElementVisibility(printIcon);
        printIcon.click();
        return this;
    }

}

