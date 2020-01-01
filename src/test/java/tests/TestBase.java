package tests; // 112619

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utils.ConfigurationReader;
import utils.Driver;

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

    }

    @BeforeMethod // 3
    public void setup(){ // 2
        String url = ConfigurationReader.getProperty("url"); // 4
        Driver.get().get(url); // 5
    //    Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // 9
    }

    @AfterMethod // 7
    public void teardown(){ // 6
        Driver.close(); // 8
    }
}
