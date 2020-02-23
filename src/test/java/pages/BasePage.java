package pages;

import mentorship.core.browser.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver webDriver;
    protected CommonActions commonActions;


    public BasePage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.commonActions = new CommonActions(webDriver);
        PageFactory.initElements(webDriver, this);
    }

}
