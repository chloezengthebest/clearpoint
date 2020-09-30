package pages;

import base.TestBase;
import driverextension.DriverExtensions;
import org.openqa.selenium.Keys;

import static pages.PageObjects.*;

public class LoginPageCountdown extends TestBase {
    public void login(String username, String password) {
        // pass username and pwd to login
        DriverExtensions.FindElement(username_cd).sendKeys(username);
        DriverExtensions.FindElement(password_cd).sendKeys(password, Keys.ENTER);
    }

    public boolean errorIsDisplayed() {
        // verify
        return DriverExtensions.FindElement(invalidLoginErrorFlag_cd).isDisplayed();
    }
}
