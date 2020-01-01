package tests.vytrack; // 120219

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.TestBase;
import utils.Driver;

public class LoginTests extends TestBase { // 1
    // added "extends TestBase"
    // we write extends TestBase to inherit @Before and @After methods.
    // This class will be dedicated to tests related to Login page only.
    // We don't have to find elements here. We should find elements in
    //  page classes only.

    @Test(description = "Verify that page title is a 'Dashboard'") // 3
    public void test1(){ // 2

        // create page object
        LoginPage loginPage = new LoginPage();  // 4

        // provide username and password
        loginPage.login("storemanager85", "UserUser123"); // 5
        // login() is coming from LoginPage class which contains @FindBy
        //  web elements. @FindBy has data from PageFactory (in LoginPage, #2).

        WebDriverWait wait = new WebDriverWait(Driver.get(),10); // 7
        wait.until(ExpectedConditions.titleIs("Dashboard")); // 8
        // Test passed
        // it is an explicit wait, it waits until title is "Dashboard"

        // Verification stage
        Assert.assertEquals(Driver.get().getTitle(), "Dashboard"); // 6
        // Driver is coming from get() method.
        // Driver.get() = driver (same thing)
        // Driver.get() returns webdriver object
    }

}
