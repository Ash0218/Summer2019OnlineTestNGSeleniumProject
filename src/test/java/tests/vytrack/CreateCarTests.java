package tests.vytrack; // 120619

import org.testng.annotations.Test;
import pages.CreateCarPage;
import pages.LoginPage;
import pages.VehiclesPage;
import tests.TestBase;
import utils.ConfigurationReader;
import utils.ExcelUtil;

import java.util.List;
import java.util.Map;

public class CreateCarTests extends TestBase { // 1
    // extended TestBase

    @Test(description = "Create some random car") // 3
    public void test1(){ // 2

        extentTest = extentReports.createTest("Create a new car"); // 16

        LoginPage loginPage = new LoginPage(); // 4
        VehiclesPage vehiclesPage = new VehiclesPage(); // 5
        CreateCarPage createCarPage = new CreateCarPage(); // 6

        loginPage.login("storemanager85", "UserUser123"); // 7
        loginPage.navigateTo("Fleet", "Vehicles"); // 8

        loginPage.waitUntilLoaderMaskDisappear(); // 10

        vehiclesPage.clickToCreateACar(); // 9

        loginPage.waitUntilLoaderMaskDisappear(); // 11

        createCarPage.licensePlateElement.sendKeys("Random"); // 12
        createCarPage.selectTags("Compact"); // 13
        createCarPage.selectFuelType("Diesel"); // 14

        loginPage.waitUntilLoaderMaskDisappear(); // 18
        createCarPage.saveAndCloseButtonElement.click(); // 15

        extentTest.pass("New car was created"); // 17

    }

    @Test(description = "Create a car by reading test data from excel file") // 20
    public void createCarTest(){ // 19
        extentTest = extentReports.createTest("Create a car by reading test data from excel file"); // 21

        LoginPage loginPage = new LoginPage(); // 21
        VehiclesPage vehiclesPage = new VehiclesPage(); // 21
        CreateCarPage createCarPage = new CreateCarPage(); // 21

        String username = ConfigurationReader.getProperty("user_name"); // 22
        // user_name -> from configuration.properties
        String password = ConfigurationReader.getProperty("password"); // 23
        // password -> from configuration.properties

        loginPage.login(username, password); // 24

        loginPage.navigateTo("Fleet", "Vehicles"); // 25

        loginPage.waitUntilLoaderMaskDisappear(); // 26

        vehiclesPage.clickToCreateACar(); // 27

        loginPage.waitUntilLoaderMaskDisappear(); // 28

        ExcelUtil excelUtil = new ExcelUtil("cars.xlsx", "cars"); // 29

        // Read data from excel spreadsheet as list of map.
        // testData is just reference variable.
        List<Map<String, String>> testData = excelUtil.getDataList(); // 30

        createCarPage.licensePlateElement.sendKeys(); // 31
    }
}
