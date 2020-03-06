package pages.user.accountPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.user.BookingPage;
import pages.user.CommonUserPage;

import static org.openqa.selenium.By.cssSelector;

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
        commonActions.waitForElementVisibility(rootElement);
    }

    public String getProfileName() {
        commonActions.waitForElementVisibility(userName);
        System.out.println("Profile name in Account Page is : " + userName.getText());
        return userName.getText();
    }

    public ProfilePage openMyProfilePage() {
        commonActions.waitForElementVisibility(profileMenu);
        profileMenu.click();
        return new ProfilePage(webDriver);

    }

    public BookingPage openBookingPage() {
        bookingsMenu.click();
        return new BookingPage(webDriver);
    }

    public boolean checkNavigationBarExistence() {
        return commonActions.isElementExist( cssSelector("nav.main-nav-menu"));
    }


}
