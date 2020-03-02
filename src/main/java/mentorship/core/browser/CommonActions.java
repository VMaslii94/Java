package mentorship.core.browser;

import mentorship.core.EnvVars.EnvVars;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
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

    public Boolean waitForCondition(WebDriver webDriver,  String expectedConditions, int defaultTimeOutSeconds){
            JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
                WebDriverWait wait = new WebDriverWait(webDriver, defaultTimeOutSeconds);
            return wait.until((ExpectedCondition<Boolean>) input -> {
                String res = jsExecutor.executeScript(expectedConditions).toString();
                return Boolean.parseBoolean(res);
            });
    }

    public CommonActions waitForElementAppearAndDisappear( WebElement element, int defaultTimeOutSeconds){
       // webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
       try {
           new WebDriverWait(webDriver, defaultTimeOutSeconds)
                   .until(ExpectedConditions.visibilityOf(element));
           System.out.println(element+ " appear");
           new WebDriverWait(webDriver, defaultTimeOutSeconds)
                   .until(ExpectedConditions.invisibilityOf(element));
           System.out.println(element+ " disapper");
           //webDriver.manage().timeouts().implicitlyWait(EnvVars.WAIT_TIMEOUT, TimeUnit.SECONDS);
       }
       catch (TimeoutException exception){
           System.out.println("For element"+ element +" was exception:"+exception);
       }
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

        webDriver.manage().timeouts().implicitlyWait(EnvVars.WAIT_TIMEOUT, TimeUnit.SECONDS);
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
