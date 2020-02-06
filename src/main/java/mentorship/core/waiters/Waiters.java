package mentorship.core.waiters;

import mentorship.core.EnvVars.EnvVars;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Waiters {
    public static void setImplicitTimeOut(WebDriver driver) {
        // wait time period and than verify
        driver.manage().timeouts().implicitlyWait(EnvVars.WAIT_TIMEOUT, TimeUnit.SECONDS);

    }

    public static void visibilityOfElementExplicitTimeOut(WebDriver driver, String elementSelectorID) {
        // wait until button start to be visible and continue on the next command
        WebDriverWait myWaiter = new WebDriverWait(driver, EnvVars.WAIT_TIMEOUT);
        myWaiter.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementSelectorID)));

    }
}
