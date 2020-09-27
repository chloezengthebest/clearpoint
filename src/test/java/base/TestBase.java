package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

import java.io.FileReader;
import java.util.Properties;

public class TestBase {
    public static WebDriver driver;
    public ExtentReports extent;
    public static ExtentTest scenarioDef;
    public static ExtentTest feature;
    public static FileReader reader;
}
