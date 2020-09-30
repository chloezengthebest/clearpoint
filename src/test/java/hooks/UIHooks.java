package hooks;

import base.TestBase;
import com.aventstack.extentreports.gherkin.model.Feature;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.ExtentReportUtil;
import utils.ScreenshotUtil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class UIHooks extends TestBase {

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
                driver.manage().window().maximize();
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
//            case "headless":
//                driver = new HtmlUnitDriver();
//                System.out.println("Driver Type is ::" + driver.toString());
//                break;
            default:
                System.out.println("BrowserType is not been support");
        }
    }

    @Before(order = 0)
    public void beforeScenario(Scenario scenario) {
        System.out.println("Before all Scenario!!");
        System.out.println("Before all Scenario!!");
        System.out.println("Before all Scenario!");

        // Initialize scenario
        ExtentReportUtil.ExtentReport();
        // create a test
        feature = ExtentReportUtil.extent.createTest(Feature.class, "twitter Feature");
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

    /**
     * @After(order = int) : This runs in decrements order, means apposite of @Before.
     * Value 1 would run first and 0 would be after 1.
     */

    @After("@chrome")
    public void afterScenario(Scenario scenario) {
        System.out.println("Taking Screenshot!!");
        if (scenario.isFailed()) {
            //Take screenshot when tests failed
            System.out.println(scenario.getName());
            String scenarioName = scenario.getName().trim();
            ScreenshotUtil.takeScreenShot(scenarioName);
        }
        System.out.println("Closing browser!!!");
        driver.quit();
    }
}
