package utils;

import base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil extends TestBase {

    public static void takeScreenShot(String scenarioName) {
        // define location
        String screenshotFilePath = projectPath + "/src/test/screenshots/";

        // convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) driver);

        // call getScreenshotAs method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

        // open the current date and time
        String timestamp = new SimpleDateFormat("yyyyMMdd__hh_mm").format(new Date());

        // the below method will save the screen shot in d drive with test method name
        try {
            FileUtils.copyFile(SrcFile, new File(screenshotFilePath + timestamp + scenarioName + ".png"));
            System.out.println("***Placed screen shot in " + screenshotFilePath + " ***");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
