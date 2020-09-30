package pages;

import base.TestBase;
import driverextension.DriverExtensions;
import org.openqa.selenium.Keys;

import static pages.PageObjects.*;

public class LoginPageTwitter extends TestBase {
    public void login(String username, String password) {
        // pass username and pwd to login
        DriverExtensions.FindElement(username_twitter).sendKeys(username);
        DriverExtensions.FindElement(password_twitter).sendKeys(password, Keys.ENTER);
    }

    public boolean errorIsDisplayed() {
        // verify
        try{
            System.out.println("invalid login error");
            return DriverExtensions.FindElement(invalidLoginErrorFlag_twitter).isDisplayed();
        }catch (Exception e)
        {
            System.out.println("unusual Login error");
            return DriverExtensions.FindElement(unusualLoginErrorFlag_twitter).isDisplayed();
        }
    }

    public boolean loginPageDisplay() {
        return DriverExtensions.FindElement(loginTitle_twitter).isDisplayed();

    }
}
