package utils; // 112619

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Driver {
    private static WebDriver driver; // 1
    // instead of WebDriver, you can use RemoteWebDriver

    // you cannot do this if constructor is private:
    //  Driver obj = new Driver()  -> wrong
    private Driver(){ // 2
    }

    // if switch statement complains on String parameter, change java
    //  version to 7+ -> better at least 8. (click shift twice ->
    //  type java compiler)
    public static WebDriver get(){ // 3
        if (driver == null){ // 4
        // if webdriver object was not created yet,

            String browser = ConfigurationReader.getProperty("browser"); // 5
            // create webdriver object based on browser value from properties
            //  file.

                switch (browser){ // 6
                    case "chrome": // 7
                        WebDriverManager.chromedriver().setup(); // 8

                        /*
                        // to configure chrome browser for tests
                        ChromeOptions chromeOptions = new ChromeOptions(); // 22
                        chromeOptions.setHeadless(true); // 23
                        driver = new ChromeDriver(chromeOptions); // 24

                        #22-24: Headless mode which makes the test run faster
                        (test runs without interface).
                        #24 works instead of #9
                        make #23 false if you want to use regular mode
                        */

                        driver = new ChromeDriver(); // 9
                        break; // 10

                    case "firefox": // 12
                        WebDriverManager.firefoxdriver().setup(); // 13
                        driver = new FirefoxDriver(); // 14
                        break; // 15

                    default: // 16
                        // if browser type is wrong, stop tests immediately and
                        //  throw exception, no browser will be opened.
                        throw new RuntimeException("Wrong browser type"); // 17
            }
        }
        return driver; // 11
        // if driver object was created, you can use it.
    }

    public static void close(){ // 18
        // if driver still exist,
        if (driver != null){ // 19
            // close all browser,
            driver.quit(); // 20
            // destroy driver object, ready for gc
            driver = null; // 21
        }
    }
}
