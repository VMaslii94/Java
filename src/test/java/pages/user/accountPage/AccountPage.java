package pages.user.accountPage;

import mentorship.core.browser.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.user.CommonUserPage;

public class AccountPage extends CommonUserPage {
    @FindBy(css = ".container")
    private WebElement rootElement;
    @FindBy(css = "a[href=\"#bookings\"]")
    private WebElement bookingsMenu;
    @FindBy(css = "a[href=\"#profile\"]")
    private WebElement profileMenu;
    @FindBy(css = "a[href=\"#wishlist\"]")
    private WebElement wishlistMenu;
    @FindBy(css = "a[href=\"#newsletter\"]")
    private WebElement newsLetterMenu;
    @FindBy(css = ".pl-30 .col-md-8 h3")
    private WebElement userName;


    public AccountPage(WebDriver webDriver) {
        super(webDriver);
        CommonActions.waitForElementVisibility(webDriver, rootElement);
    }

    public String getProfileName() {
        CommonActions.waitForElementVisibility(webDriver, userName);
        System.out.println("Profile name in Account Page is : " + userName.getText());
        return userName.getText();
    }

    public ProfilePage openMyProfileMenu() {
        CommonActions.waitForElementVisibility(webDriver, profileMenu);
        profileMenu.click();
        return new ProfilePage(webDriver);

    }

    public void openBookingMenu() {
        bookingsMenu.click();
    }


}
