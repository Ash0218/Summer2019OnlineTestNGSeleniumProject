package tests.day3; // two

import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class BrowserFactoryTest {
    public static void main(String[] args) { // 1
        // Now, we can get webdriver -> getDriver() method will return
        //  webdriver object and we can use reference variable to work
        //  with that object.
        WebDriver driver = BrowserFactory.getDriver("chrome"); // 2
        // how we can print a source code of a web page?
        driver.get("http://practice.cybertekschool.com"); // 3
        System.out.println(driver.getPageSource()); // 4
        // to finish this execution.
        driver.quit(); // 5
    }
}
