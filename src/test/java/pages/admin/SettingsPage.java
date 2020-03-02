package pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

public class SettingsPage extends BasePage {
    @FindBy(css = "form[enctype= \"multipart/form-data\"]")
    private WebElement rootElement;

    @FindBy(css = "select[name= \"multi_lang\"]")
    private WebElement multiLanguage;

    @FindBy(css = "button.btn-block")
    private WebElement submitBtn;


    public SettingsPage(WebDriver webDriver) {
        super(webDriver);
        commonActions.waitForElementVisibility(rootElement);
        commonActions.waitForElementVisibility(submitBtn);
    }

    public SettingsPage setMultiLanguageField(String flag) {
        commonActions.waitForElementVisibility(multiLanguage);
        Select multiLanguageList = new Select(multiLanguage);
        multiLanguageList.selectByVisibleText(flag);
        return this;
    }

    public String getSelectedMultiLanguageValue(){
        Select select = new Select(multiLanguage);
        WebElement option = select.getFirstSelectedOption();
        String item = option.getText();
        return item;
    }

    public SettingsPage submitChanges() {
        submitBtn.click();
        return this;
    }

}
