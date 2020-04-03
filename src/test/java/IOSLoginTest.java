import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_pbjects.LoggedInView;
import page_pbjects.LoginView;
import page_pbjects.MainView;

public class IOSLoginTest {


    IOSDriver driver;
    WebDriverWait wait;
    private MainView mainView;
    private LoginView loginView;
    private LoggedInView loggedInView;

    @Before
    public void setUp() throws MalformedURLException, URISyntaxException {
        URL appiumUrl = new URL("http://0.0.0.0:4723/wd/hub");
//        URL resource = getClass().getClassLoader().getResource("apps/TheApp.app");
//        URL resource = getClass().getClassLoader().getResource("apps/UK-TH.app");
//        File app = Paths.get(resource.toURI()).toFile();
        DesiredCapabilities caps = new DesiredCapabilities(); 
        caps.setCapability("platformName", "iOS");
        caps.setCapability("platformVersion", "13.3");
        caps.setCapability("usePrebuiltWDA", true);
        caps.setCapability("deviceName", "iPhone 11 Pro");
        caps.setCapability("app", "/Users/gopikrishna.kovuru/Documents/TUI/Automation/bootcamp/apps/TheApp.app" );
        driver = new IOSDriver(appiumUrl, caps);
        wait = new WebDriverWait(driver,10);
        mainView = new MainView(driver);
        System.out.println("Main view is working");
        loginView = new LoginView(driver);
        loggedInView = new LoggedInView(driver);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    private WebElement safeFind(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }


    public void testLogin(){
        driver.findElement(MobileBy.AccessibilityId("Login Screen")) .click();
        driver .findElement(By.xpath("//XCUIElementTypeTextField[@name=\"username\"]")) .sendKeys("alice");
        driver .findElement(By.xpath("//XCUIElementTypeSecureTextField[@name=\"password\"]")) .sendKeys("mypassword");
        driver .findElement(MobileBy.AccessibilityId("loginBtn")) .click();
        driver.findElement(MobileBy.AccessibilityId("You are logged in as alice"));
    }


    public void testLoginsafe(){
        safeFind(MobileBy.AccessibilityId("Login Screen")) .click();
        safeFind(By.xpath("//XCUIElementTypeTextField[@name=\"username\"]")) .sendKeys("alice");
        safeFind(By.xpath("//XCUIElementTypeSecureTextField[@name=\"password\"]")) .sendKeys("mypassword");
                        safeFind(MobileBy.AccessibilityId("loginBtn")) .click();
        safeFind(MobileBy.AccessibilityId("You are logged in as alice"));
    }

    @Test
    public void testLoginsPage(){
        final String username = "alice";
        final String password = "mypassword";
        mainView.navToLogin();
        loginView.login(username, password);
        String loggedInUsername = loggedInView.getLoggedInUsername();
        Assert.assertEquals(loggedInUsername, username);
    }
}
