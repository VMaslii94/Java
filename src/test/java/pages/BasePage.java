package pages;

import mentorship.core.browser.CommonActions;
import mentorship.core.reporters.AllureReport;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver webDriver;
    protected CommonActions commonActions;
    protected AllureReport allureReport;


    public BasePage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.commonActions = new CommonActions(webDriver);
        this.allureReport = new AllureReport(webDriver);
        PageFactory.initElements(webDriver, this);
    }



}
