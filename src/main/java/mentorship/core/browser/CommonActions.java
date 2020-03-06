package mentorship.core.browser;

import mentorship.core.EnvVars.EnvVars;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static mentorship.core.EnvVars.EnvVars.WAIT_TIMEOUT;

public class CommonActions {


    private  WebDriver webDriver;



    public CommonActions(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public WebDriver get(){
        return this.webDriver;
    }
    public CommonActions waitForElementVisibility(WebElement element) {
        new WebDriverWait(webDriver, EnvVars.WAIT_TIMEOUT)
                .until(ExpectedConditions.visibilityOf(element));
        return this;
    }
    public CommonActions waitForElementVisibilityWithTime(WebElement element, int defaultTimeout) {
        new WebDriverWait(webDriver, defaultTimeout)
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

    public void waitForCondition(Function<? super WebDriver, Boolean> function, int timeout) {
        //WebDriverWait wait = new WebDriverWait(webDriver.get(), timeout, 300);
        WebDriverWait wait = new WebDriverWait(webDriver, timeout, 300);
        wait.until(function);
    }

    public void waitForElementNotExist(WebElement element) {
        waitForCondition((el) -> !isElementExist(element), WAIT_TIMEOUT);
    }

    public void waitForElementNotExist(By locator) {
        waitForCondition((el) -> !isElementExist(locator), WAIT_TIMEOUT);
    }

    public void waitForElementAppearAndDisappear(WebElement element) {
        try {
            waitForCondition((el) -> isElementExist (element), 2);
        } catch (TimeoutException e) {
        }
        waitForElementNotExist(element);
    }

    public void waitForElementAppearAndDisappear(By locator) {
        try {
            waitForCondition((el) -> isElementExist(locator), 2);
        } catch (TimeoutException e) {
        }
        waitForElementNotExist(locator);
    }

    public void waitForElementAppearAndDisappear(WebElement element, int defaultTimeOutSeconds) {
        // webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        try {
            waitForElementVisibilityWithTime(element, defaultTimeOutSeconds);
            System.out.println(element + " appear");
            new WebDriverWait(webDriver, defaultTimeOutSeconds)
                    .until(ExpectedConditions.invisibilityOf(element));
            System.out.println(element + " disapper");
            //webDriver.manage().timeouts().implicitlyWait(EnvVars.WAIT_TIMEOUT, TimeUnit.SECONDS);
        } catch (TimeoutException exception) {
            System.out.println("For element" + element + " was exception:" + exception);
        }

    }

    public  Boolean isElementExist( WebElement element) {
        //Set implict wait to 0
        webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        Boolean flag = true;
        try {
            element.isDisplayed();
        }
        catch (NoSuchElementException ex) {
            // Do something when the second button does not exist
            System.out.println("No element exist !!! by selector : " + element);
            flag = false;
        }
        webDriver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT, TimeUnit.SECONDS);
        return flag;
    }


    public Boolean isElementExist(By selector) {

        //Set implict wait to 0
        webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        boolean exists = webDriver.findElements(selector).size() != 0;
        if (exists) {
            System.out.println("Element exist : " + selector);

        } else {
            System.out.println("No element exist !!! by selector : " + selector);
        }

        webDriver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT, TimeUnit.SECONDS);
        return exists;

    }

}
