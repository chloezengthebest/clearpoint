package pages;

import base.TestBase;
import driverextension.DriverExtensions;
import org.openqa.selenium.WebElement;

import static pages.PageObjects.*;

public class HomePageCountdown extends TestBase {
    public void CloseEmailSignUpWindow() {
        // switch to main page
        driver.switchTo().defaultContent();

        // find close button of iframe
        WebElement closeButton = DriverExtensions.FindElement(closeButtonOnFrame_cd);
        closeButton.click();
    }

    public boolean VerifyEmailFrame() {
        // find iframe
        WebElement iframe = DriverExtensions.FindElement(emailFrame_cd);
        driver.switchTo().frame(iframe);

        // verity
        return DriverExtensions.FindElement(emailFieldOnFrame_cd).isDisplayed();
    }

    public boolean VerifyHomePageDisplayed() {
        // verity
        return DriverExtensions.FindElement(countdownicon_cd).isDisplayed();
    }
}
