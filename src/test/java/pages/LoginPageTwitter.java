package pages;

import base.TestBase;
import driverextension.DriverExtensions;
import org.openqa.selenium.Keys;

import static pages.PageObjects.*;

public class LoginPageTwitter extends TestBase {
    public void login(String username, String password) {
        // pass username and pwd to login
        DriverExtensions.FindElement(driver, username_twitter).sendKeys(username);
        DriverExtensions.FindElement(driver, password_twitter).sendKeys(password, Keys.ENTER);
    }

    public boolean errorIsDisplayed() {
        // verify
        return DriverExtensions.FindElement(driver, invalidLoginErrorFlag_twitter).isDisplayed();
    }

    public boolean loginPageDisplay() {
        return DriverExtensions.FindElement(driver, loginTitle_twitter).isDisplayed();

    }
}
