package tests.vytrack; // 120319

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.TestBase;

public class NewCalendarEventsTests extends TestBase { // 1
    // add extends TestBase

    @Test(description = "Verify that page subtitle is equals to 'All Calendar Events") // 3
    public void test1(){ // 2

        extentTest = extentReports.createTest("Verify that page subtitle is equals to 'All Calendar Events"); // 10
        // this step is required for every test.
        //  Otherwise, you will get nullpointer exception. You must
        //  create a test at the beginning.

        LoginPage loginPage = new LoginPage(); // 4
        // login page object

        loginPage.login("storemanager85", "UserUser123"); // 5
        // #5 replaces:
        // driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        // driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);

        loginPage.navigateTo("Activities", "Calendar Events"); // 6

        String expectedSubtitle = "All Calendar Events"; // 7
        String actualSubTitle = loginPage.getPageSubTitle(); // 8

        Assert.assertEquals(actualSubTitle, expectedSubtitle); // 9
        // Test failed -> ElementClickInterceptedException -> there is a
        //  shield in the website, it protects itself from any interraction
        //  from outside. You couldn't click it.
        // Where we got failed? Check the colored lines:
        /*  at tests.vytrack.NewCalendarEventsTests.test1(NewCalendarEventsTests.java:21)
            at pages.BasePage.navigateTo(BasePage.java:104)

            There are colored blue.
         */

        extentTest.pass("Verified that page subtitle 'All Calendar Events' is displayed"); // 11



    }
}
