package pages.admin.customers.Customers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.admin.page_modules.sideBar.customersTable.TwentyFiveItems;

public class Customers extends BasePage {


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

    public Customers(WebDriver webDriver) {
        super(webDriver);

        commonActions.waitForElementVisibility(rootElement);
        PageFactory.initElements(webDriver, this);
    }

    public Customers waitForProgressBar() {
        commonActions.waitForElementAppearAndDisappear(progressBar, 5);
        return this;
    }

    public TwentyFiveItems changeViewOn25Items() {
        commonActions.waitForElementVisibility(twentyFiveIcon);
        //commonActions.jsExecute("window.scrollTo(0, document.body.scrollHeight)");
        twentyFiveIcon.click();
//        String a = "document.querySelector(\"button[data-limit='25']\").click()";
//        commonActions.jsExecute("document.querySelector(\"button[data-limit='25']\").click()");
        waitForProgressBar();
        return new TwentyFiveItems(webDriver);
    }

    public void clickAddBtn() {
        commonActions.waitForElementVisibility(addBtn);
        addBtn.click();
        // TODO: add create customer form and return in this method
    }
    public Customers clickPrintBtn(){
        commonActions.waitForElementVisibility(printIcon);
        printIcon.click();
        return this;
    }

}

