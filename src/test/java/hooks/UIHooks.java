package hooks;

import com.aventstack.extentreports.gherkin.model.Feature;
import base.TestBase;
import base.ExtentReportUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class UIHooks extends TestBase {

    public static Properties p = new Properties();
    ExtentReportUtil extentReportUtil = new ExtentReportUtil();
    public static String projectPath = System.getProperty("user.dir");

    @Before("@chrome")
    public static void initializeDriver() {
        System.out.println("Initializing Driver!!");
        System.out.println("Initializing Driver!!");
        System.out.println("Initializing Driver!!");
        String browserType = p.getProperty("browser");
        // Initialize driver
        switch (browserType) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/java/driver/chromedriver");
                driver = new ChromeDriver();
                System.out.println("Driver Type is ::" + driver.toString());
                break;
            case "chromeHeadless":
                System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/java/driver/chromedriver");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless", "--silent");
                driver = new ChromeDriver(options);
                System.out.println("Driver Type is ::" + driver.toString());
                break;
            case "firefox":
                // Add firefox driver here
                break;
            case "headless":
                driver = new HtmlUnitDriver();
                System.out.println("Driver Type is ::" + driver.toString());
                break;
            default:
                System.out.println("BrowserType is not been support");
        }
    }

    @After("@chrome")
    public void closeBrowser() {
        System.out.println("Closing browser!!!");
        driver.quit();
    }

    @After(order = 99)
    public void generateReport(Scenario scenario) {
        System.out.println("Generating Extent Report!!");
        if (scenario.isFailed()) {
            //Take screenshot logic goes here
            System.out.println(scenario.getName());
        }
        extentReportUtil.FlushReport();
    }

    @Before(order = 0)
    public void beforeScenario(Scenario scenario) {
        System.out.println("Before all Scenario!!");
        System.out.println("Before all Scenario!!");
        System.out.println("Before all Scenario!");

        // Initialize scenario
        extentReportUtil.ExtentReport();
        // create a test
        feature = extentReportUtil.extent.createTest(Feature.class, "twitter Feature");
        // create note for scenario
        scenarioDef = feature.createNode(scenario.getName());

        try {
            // fetch browser type from config file
            reader = new FileReader(projectPath + "/src/test/java/config/config.properties");
            // reads a property list
            p.load(reader);
        } catch (FileNotFoundException e1) {
            System.out.println("MSG:: Config File not been found, please check path:" + e1);
        } catch (IOException e2) {
            System.out.println("MSG:: Unable to read config properties:" + e2);
        }

    }

}
