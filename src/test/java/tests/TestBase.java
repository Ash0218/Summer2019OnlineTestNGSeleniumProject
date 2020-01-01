package tests; // 112619

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigurationReader;
import utils.Driver;

import java.util.concurrent.TimeUnit;

// this class will be a test foundation for all test classes
// we will put here only before and after parts
// In this way, before and after methods will be the same.
// every test class will extend TestBase class.
public abstract class TestBase { // 1

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
