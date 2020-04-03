package page_pbjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator; import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSFindBy;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginView {

    @FindBy(xpath = "//XCUIElementTypeTextField[@name=\"username\"]")
    private WebElement usernameField;

    @FindBy(xpath = "//XCUIElementTypeSecureTextField[@name=\"password\"]")
    private WebElement passwordField;

    @iOSXCUITFindBy(accessibility = "loginBtn")
    private WebElement loginBtn;

    public LoginView(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void login(String username, String password) {
        usernameField.sendKeys(username); passwordField.sendKeys(password); loginBtn.click();
    }
}
