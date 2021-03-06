package tests; // 112619

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;
import org.testng.annotations.*;
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

    protected static ExtentReports extentReports; // 9
    // ExtentReports itself does not build any reports, but allows reporters
    //  to access information, which in turn build the said reports.
    //  Ex of building an HTML report and adding info to ExtentX:
    //   ExtentHtmlReporter html = new ExtentHtmlReporter("Extent.html");
    //   ExtentXReporter extentx = new ExtentXReporter)"localhost");
    // Make sure that it is static or it will work for only first test, not
    //  for the rest.

    protected static ExtentHtmlReporter extentHtmlReporter; // 10
    // the ExtentHtmlReporter creates a rich standalone HTML file. It
    //  allows several

    protected static ExtentTest extentTest; // 11
    //  Defines a test. You can add logs, snapshots, assign author and categories to a test and its children.

    @BeforeTest // 13
    @Parameters({"test", "env_url"}) // 33, 43
    // "test" and @parameter are from testng.xml -> <parameter name="test"
    // the value="regression" from testng.xml is passed to String test
    //  in #34.
    // #43: added "env_url" after adding QA2,3 in smoke_test.xml

  //  public void beforeTest(){ // 1
      public void beforeTest(@Optional String test, @Optional String env_url){    // 34, 44
        // @Optional String test -> added to #1 after #33
        // #44: added @Optional String env_url after QA2,3 in smoke_test.xml

        String reportName = "report"; // 36
        // the reportName is "report" (it is from #13, /report.)

        if (test != null) {// 35
            // if this test variable is not null,
            reportName = test; // 37
            // the reportName is test.
        }

  //      String filePath = System.getProperty("user.dir") + "/test-output/report.html"; // 13
        // filepath: location of report. It's gonna be  next to target
        //  folder, test-output folder (where the report is saved).
        // -> /Applications/IntelliJ IDEA CE.app/Summer2019OnlineTestNGSeleniumProject

        String filePath = System.getProperty("user.dir") + "/test-output/" +reportName+".html"; // 38
        // changed report (#13) to reportName after creating testng.xml

        extentReports = new ExtentReports(); // 14
        extentHtmlReporter = new ExtentHtmlReporter(filePath); // 15
        extentReports.attachReporter(extentHtmlReporter); // 16
        extentHtmlReporter.config().setReportName("Vytrack Test Results"); // 17

        // System information (#45,46,47,18,48,19,20)
        String env = ConfigurationReader.getProperty("url"); // 45
        if (env_url != null) {// 46
            // if env-url is not null, then change
            env = env_url; // 47
            // env to env_url
        }
       // extentReports.setSystemInfo("Environment", "QA1"); // 18
        extentReports.setSystemInfo("Environment", env); // 48
        // changed #18 to #48

        extentReports.setSystemInfo("Browser", ConfigurationReader.getProperty("browser")); // 19
        extentReports.setSystemInfo("OS", System.getProperty("os.name")); // 20
    }

    @AfterTest // 22
    public void afterTest(){ // 21
        extentReports.flush(); // 23
        // Writes test info from the started reporters to their output view
    }


// <parameter name="env_url" value="https://qa3.vytrack.com/"></parameter>
// added from #39 after creating smoke_test.xml
    @BeforeMethod // 3
    @Parameters("env_url") // 39
//    public void setup(){ // 2
    public void setup(@Optional String env_url){  // 40
        // added to #2

        String url = ConfigurationReader.getProperty("url"); // 4

        if (env_url != null) { // 41
            // if env_url is not null,
            url = env_url;  // 42
            // url = env_url.
            // If name parameter was set, use it. if it' null, that
            //  means it was not set.
        }

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
                // This method throws IOExeption (which is checked exception)
                //  Any checked exception must be handled.

            } catch (IOException e){ // 29
                e.printStackTrace(); // 30
                // prints error info
            }

        } else if (result.getStatus() == ITestResult.SKIP){ // 31
            extentTest.skip("Test case was skipped : " + result.getName()); // 32
        }

        Driver.close(); // 8
    }
}

