package driverextension;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class DriverExtensions extends TestBase {

    private static final int timeoutInSeconds = 10;

    public static WebElement FindElement(By by) {

        if (timeoutInSeconds > 0) {
            // define WebDriver wait
            WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);

            // define condition is visibility
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return element;
        }
        return driver.findElement(by);
    }

    public static void SwitchToNewWindow(By by) {

        // It will return the parent window name as a String
        String originalWindow = driver.getWindowHandle();

        //Check we don't have other windows open already
        assert driver.getWindowHandles().size() == 1;

        //Click the link which opens in a new window
        WebElement element = FindElement(by);
        element.click();

        // define WebDriver wait
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);

        //Wait for the new window or tab
        wait.until(numberOfWindowsToBe(2));

        //Loop through until we find a new window handle
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}