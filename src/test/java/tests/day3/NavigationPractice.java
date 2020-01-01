package tests.day3; // three

import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class NavigationPractice {
    public static void main(String[] args) { // 1
        // Create a webdriver object to work with a browser
        WebDriver driver = BrowserFactory.getDriver("chrome"); // 2
        // Don't need WebDriverManager b.c it's already inside the utils pakage.
        driver.manage().window().maximize(); // 4
        // to maximize browser window

        driver.get("http://google.com"); // 3

        BrowserUtils.wait(3); // 10
        // wait for 3 seconds: this is our custom method. Since method is
        //  static, we use class name to call the method as a parameter,
        //  we provide number of seconds(time in seconds).

        // How to print Page Title? getTitle()
        System.out.println(driver.getTitle()); // 11
        // -> Google

        driver.navigate().to("http://amazon.com"); // 5
        // go in the same browser.

        // Navigate back to google (previous URL)
        driver.navigate().back(); // 6

        // move forward to the amazon again
        driver.navigate().forward(); // 7

        // to refresh/ reload webpage/ website:
        driver.navigate().refresh(); // 8

        driver.getTitle(); // 14
        // <title>Google</title> -> anything between title will appear

        // shutdown browser:
        // driver.quit(); // 9
        driver.close(); // 13
        // -> NoSuchSessionException -> same result as #9 b.c there is
        //  only one tab and it was closed, so we can't do anything
        // If tab is only one, close() will shutdown browser, and we
        //  cannot use driver anymore. So, we have to re-create an object
        //  of WebDriver.

        // What will happen if I call driver again after quit()?
        driver.get("http://google.com"); // 12
        // -> NoSuchSessionException

    }
}
