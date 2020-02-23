package mentorship.core.browser;

import mentorship.core.EnvVars.EnvVars;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CommonActions {


    protected WebDriver webDriver;

    public CommonActions(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public CommonActions waitForElementVisibility( WebElement element) {

        new WebDriverWait(webDriver, EnvVars.WAIT_TIMEOUT)
                .until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    public CommonActions jsExecute(String script) {
        //Creating the JavascriptExecutor interface object by Type casting
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript(script);
        return this;
    }

    public CommonActions closeAlertWindow() {
        webDriver.switchTo().alert().dismiss();
        return this;
    }

    public static Boolean checkIfElementExistCssSelector(WebDriver webDriver, String selector) {

        //Set implict wait to 0
        webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        boolean exists = webDriver.findElements(By.cssSelector(selector)).size() != 0;
        if (exists) {
            System.out.println("Element exist : " + selector);

        } else {
            System.out.println("No element exist !!! by selector : " + selector);
        }
        return exists;

//        List<WebElement> dynamicElement = webDriver.findElements(By.id("id"));
//        if(dynamicElement.size() != 0){
//
//            //If list size is non-zero, element is present
//            System.out.println("Element present");
//            return true;
//        }
//        else{
//            //Else if size is 0, then element is not present
//            System.out.println("Element not present");
//            return false;
//        }
    }

}
