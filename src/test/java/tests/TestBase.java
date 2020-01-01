package tests; // 112619

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utils.BrowserUtils;
import utils.ConfigurationReader;
import utils.Driver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

// this class will be a test foundation for all test classes
// we will put here only before and after parts
// In this way, before and after methods will be the same.
// every test class will extend TestBase class.
public abstract class TestBase { // 1

    protected ExtentReports extentReports; // 9
    // ExtentReports itself does not build any reports, but allows reporters
    //  to access information, which in turn build the said reports.
    //  Ex of building an HTML report and adding info to ExtentX:
    //   ExtentHtmlReporter html = new ExtentHtmlReporter("Extent.html");
    //   ExtentXReporter extentx = new ExtentXReporter)"localhost");

    protected ExtentHtmlReporter extentHtmlReporter; // 10
    // the ExtentHtmlReporter creates a rich standalone HTML file. It
    //  allows several

    protected ExtentTest extentTest; // 11
    //  Defines a test. You can add logs, snapshots, assign author and categories to a test and its children.

    @BeforeTest // 13
    public void beforeTest(){ // 12
        String filePath = System.getProperty("user.dir") + "/test-output/report.html"; // 13
        // filepath: location of report. It's gonna be  next to target
        //  folder, test-output folder.
        // -> /Applications/IntelliJ IDEA CE.app/Summer2019OnlineTestNGSeleniumProject

        extentReports = new ExtentReports(); // 14
        extentHtmlReporter = new ExtentHtmlReporter(filePath); // 15
        extentReports.attachReporter(extentHtmlReporter); // 16
        extentHtmlReporter.config().setReportName("Vytrack Test Results"); // 17

        // System information
        extentReports.setSystemInfo("Environment", "QA1"); // 18
        extentReports.setSystemInfo("Browser", ConfigurationReader.getProperty("browser")); // 19
        extentReports.setSystemInfo("OS", System.getProperty("os.name")); // 20
    }

    @AfterTest // 22
    public void afterTest(){ // 21
        extentReports.flush(); // 23
        // Writes test info from the started reporters to their output view
    }

    @BeforeMethod // 3
    public void setup(){ // 2
        String url = ConfigurationReader.getProperty("url"); // 4
        Driver.get().get(url); // 5
    //    Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // 9
    }

    @AfterMethod // 7
    public void teardown(ITestResult result){ // 6
        // ITestResult is from TestNG. It described the result of test.

        if (result.getStatus() == ITestResult.FAILURE){ // 24
            extentTest.fail(result.getName()); // 25
            extentTest.fail(result.getThrowable()); // 26
            try { // 28
                extentTest.addScreenCaptureFromPath(BrowserUtils.getScreenshot(result.getName())); // 27
                // BrowserUtils.getScreenshot(result.getName()) -> takes
                //  screenshot and returns location of that screenshot.

            } catch (IOException e){ // 29
                e.printStackTrace(); // 30
            }

        } else if (result.getStatus() == ITestResult.SKIP){ // 31
            extentTest.skip("Test case was skipped : " + result.getName()); // 32
        }

        Driver.close(); // 8
    }
}

