package utils;

import base.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportUtil extends TestBase {

    public static void ExtentReport() {
        //First is to create Extent Report Instance
        fileName = projectPath + "/src/test/reports/extentReport.html";

        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);

        extent = new ExtentReports();

        //changed to spark instead
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("ClearPoint");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("ClearPoint Test report Demo--Chloe Zeng");
        extent.attachReporter(htmlReporter);
    }

    public static void FlushReport() {
        extent.flush();
    }
}
