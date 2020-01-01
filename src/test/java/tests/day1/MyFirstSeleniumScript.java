package tests.day1; // 101519

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstSeleniumScript {
    public static void main(String[] args) { // 1

      //  System.setProperties("webdriver.chrome.driver", "/path/chromedriver"); // 2
        // Old version of WebDriverManager.chromedriver().setup();
        //  sometimes use this one tp configure webdriver.
        // The new way is better to setup WebDriver b.c any platform
        //  and any version is available in one line of code.

        WebDriverManager.chromedriver().setup(); // 2
        // we have to setup webdriver based on the browser that we gonna use
        // next, we need to create an object of appropriate class
        ChromeDriver driver = new ChromeDriver(); // 3
        // lt's open google.com
        // .get() method allows us to open some website
       // all commands go through driver
        driver.get("http://google.com"); // 4
        // orders driver to get google website

        // Test 1: Verify that title of the page is a "Google"
        // To read page title, there is metod: .getTitle()
        String actualResult = driver.getTitle(); // 6
        String expectedResult = "Google"; // 7
        if (actualResult.equals(expectedResult)) { // 8
            // If actualResult is equals to expectedResult
            System.out.println("Test passed"); // 9
        } else { // 10
            System.out.println("Test failed"); // 11
            // Test passed
        }

        // to close browser at the end of test execution
        driver.close(); // 5

    }
}
