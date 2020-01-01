package tests.day14; // two

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import tests.TestBase;
import utils.BrowserUtils;
import utils.ConfigurationReader;
import utils.Driver;

public class LoginTest extends TestBase { // 9
    // added "extends TestBase"

    @Ignore // 8
    // ignore test1
    @Test // 6
    public void test1(){ // 1
        String url = ConfigurationReader.getProperty("url"); // 2
        // read url values from the properties file.

        Driver.get().get(url); // 3
        // Driver.get() -> will return webdriver object and then we can call
        //  webdriver methods like get(), findElement(), ...
        // #3 is same to this: WebDriver driver = Driver.get();

        System.out.println(Driver.get().getTitle()); // 7
        // print page title
        // -> Login

        BrowserUtils.wait(2); // 5
        Driver.close(); // 4

    }

    @Test // 13
    public void test2(){ // 10
        System.out.println(Driver.get().getTitle()); // 11
        BrowserUtils.wait(2); // 12
        // -> Login
    }

}
