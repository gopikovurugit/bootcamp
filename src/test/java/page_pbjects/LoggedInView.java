package page_pbjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator; import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSFindBy;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
public class LoggedInView {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, ‘You are logged in as’)]")
    private WebElement loggedInMsg;

    public LoggedInView(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public String getLoggedInUsername() {
        String text = loggedInMsg.getText();
        return text.replaceAll(".*You are logged in as ([^ ]+).*", "$1");
    }
}
