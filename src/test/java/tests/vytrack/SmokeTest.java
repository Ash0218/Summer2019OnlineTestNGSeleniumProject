package tests.vytrack; // 120619

import org.testng.annotations.DataProvider;
import tests.TestBase;

public class SmokeTest extends TestBase { //1
    // Extended TestBase

    @DataProvider(name = "navigationInfo") // 3
    public Object[][] navigationInfo(){ // 2
        return new Object[][]{ // 4
                {"DashBoards", "Dashboard", "Dashboard"}, // 5
                // DashBoards and Dashboard are from the Vytrack website
                {"DashBoards", "Manage Dashboards", "All Manage Dashboards" }, // 6
                {"Fleet", "Vehicles", "All Cars"}, // 7
                {"Customers", "Accounts", "All Accounts"} // 8
        };
    }
}
