package tests.vytrack; // 120619

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.TestBase;

public class SmokeTest extends TestBase { //1
    // Extended TestBase
    // configuration.properties also used

    @Test(dataProvider = "navigationInfo") // 10
    public void smokeTest(String moduleName, String subModuleName, String pageSubTitle){ // 9
        // putting the module names (#4,5,6,7,8) into #9 Test
        // Run the test 4 times (for #5,6,7,8), so #9 has 3 variables
        // (1,2,3), and #5,6,7,8 also have 3 variables with comma.
        // If it fails b.c of being too slow, then change the time
        //  in #20 of BasePage to 30 seconds.

        extentTest = extentReports.createTest("Verify that page subtitle is equals to " + pageSubTitle); // 15
        // report

        LoginPage loginPage = new LoginPage(); // 11
        // Create login page

        loginPage.login("storemanager85", "UserUser123"); // 12
        // login with username and password

        loginPage.navigateTo(moduleName, subModuleName); // 13
        // navigate into moduleName and subModuleNAme

        loginPage.waitUntilLoaderMaskDisappear(); // 19

        Assert.assertEquals(loginPage.getPageSubTitle(), pageSubTitle); // 14
        // Verify login page is the sub title.

        extentTest.pass("Verified that page subtitle, ' " + pageSubTitle + " ' is displayed"); // 16


    }

    @DataProvider(name = "navigationInfo") // 3
    public Object[][] navigationInfo(){ // 2
        return new Object[][]{ // 4
                {"Dashboards", "Dashboard", "Dashboard"}, // 5
                // DashBoards and Dashboard are from the Vytrack website
                {"Dashboards", "Manage Dashboards", "All Manage Dashboards" }, // 6
                {"Fleet", "Vehicles", "All Cars"}, // 7
                {"Customers", "Accounts", "All Accounts"}, // 8
                {"Activities", "Calls", "All Calls"}, // 18
                {"Activities", "Calendar Events", "All Calendar Events"}, // 17
                {"Sales", "Opportunities", "Open Opportunities"} // 20
        };
    }
}
