package mentorship.core.browser;

import mentorship.core.EnvVars.EnvVars;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CommonActions {


    public static void waitForElementVisibility(WebDriver webDriver, WebElement element) {

        new WebDriverWait(webDriver, EnvVars.WAIT_TIMEOUT)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static Boolean checkIfElementExistCssSelector(WebDriver webDriver, String selector) {

        //Set implict wait to 0
        webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        boolean exists = webDriver.findElements(By.cssSelector(selector)).size() != 0;
//        if (exists) {
//            System.out.println("Element exist : " + selector);
//        } else {
//            System.out.println("No element exist !!! by selector : " + selector);
//        }

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
