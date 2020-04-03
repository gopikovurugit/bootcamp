package page_pbjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator; import io.appium.java_client.pagefactory.WithTimeout;

import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class MainView {

    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    @iOSXCUITFindBy(accessibility = "Login Screen")
    private WebElement navToLoginBtn;

    public MainView(AppiumDriver driver) {
        System.out.println("On main view");
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public void navToLogin() {
        navToLoginBtn.click();
    }
}
