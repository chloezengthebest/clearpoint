package pages;

import base.TestBase;
import driverextension.DriverExtensions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static pages.PageObjects.*;

public class LoginPageCountdown extends TestBase {
    public void login(String username, String password) {
        // pass username and pwd to login
        DriverExtensions.FindElement(driver, username_cd).sendKeys(username);
        DriverExtensions.FindElement(driver, password_cd).sendKeys(password, Keys.ENTER);
    }

    public boolean errorIsDisplayed() {
        // verify
        return DriverExtensions.FindElement(driver, invalidLoginErrorFlag_cd).isDisplayed();
    }
}
