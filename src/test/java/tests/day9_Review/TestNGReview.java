package tests.day9_Review;  // 111519   one

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestNGReview {

    private WebDriver driver; // 10

    @BeforeMethod // 4
    public void setup() { // 3
        System.out.println("Before method!"); // 5
        // Before method runs only with Test method.
        // Whatever is common among tests, can go into @Beforemethod and
        //  @Aftermethod.
        // It helps to reduce code duplication

        driver = BrowserFactory.getDriver("chrome"); // 11
    }

    @AfterMethod // 8
    public void teardown() { // 7
        System.out.println("After method!"); // 9
        BrowserUtils.wait(3); // 12
        driver.quit(); // 12
    }

    @Test(description = "Verify title of google.com", priority = 2) // 2
    public void test1() { // 1
        System.out.println("Test 1"); // 6
        driver.get("http://google.com"); // 13
        String expectedTitle = "Google"; // 14
        String actualTitle = driver.getTitle(); // 15
        Assert.assertEquals(actualTitle, expectedTitle, "Title is not correct!"); // 16
        // If this assertion failed, then the message "Title is not correct!"
        //  will be printed out.
        System.out.println("Test passed!"); // 23
        // If the assertion passes, then #23 will be printed. But if it fails,
        //  then, the message in #16 will be printed.
    }

    @Test(description = "Verify title of apple.com", priority = 1) // 18
    // priority = 1 -> it runs before #2
    // priority will change the order of test execution. By default, tests
    //  are running in alphabetic order (a,b,c,d,... from the method name).
    //  Lower priority -> eariler execution. Tests will run: priority 1 ->
    //  priority 2 -> 3... priotiry = 0 does not work, but priority = -1 works
    //  first.
    public void verifyApplesPageTitle() { // 17
        System.out.println("Test 2"); // 19
        driver.get("https://www.apple.com/"); // 20
        String expectedTitle = "Apple"; // 20
        String actualTitle = driver.getTitle(); // 21
        Assert.assertEquals(actualTitle, expectedTitle, "Title is not correct!"); // 22
        // -> Test passed
        // -> Test 2
        // If assertion failed, the message in #22 will be printed. If it
        //  passed, then #24 will be printed.
        System.out.println("Test passed!"); // 24
    }


    // dataProvider can supply test with a test data. Also, it allows to do
    //  Data-Driven testing (when the test runs multiple times with different
    //   test data set).
    @DataProvider(name = "testData") // 26
    public static Object[][] testData(){  // 25
        return new Object[][]{{"https://www.apple.com/", "Apple"},
                {"http://google.com", "Google"}}; // 26
        // 2 sets of data: 1. Apple -> www.apple.com, 2. Google -> www.google.com


}


    @Test(dataProvider = "testData") // 28
    // this test will run twice b.c we have 2 sets of data.
    // dataProvider must return 2nd array of Object. 1st parameter =
    //  1st object in the inner array, 2nd parameter = 2nd object in the
    //  inner array.
    // We can have as many as sets of data as we want.
    public void testWithDataProvider(String url, String title){ // 27
        // String url -> www.apple.com, http://google.com
        // String title -> Apple, Google
        driver.get(url); // 29
        Assert.assertEquals(driver.getTitle(), title); // 30
        // -> Test passed: 2
}





}
