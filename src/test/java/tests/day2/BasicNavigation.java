package tests.day2; // one

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) { // 1
        // why do we need main method? to run the program
        // If you have exception like Cannot load a class, that means
        //  that package name doesn't match with location of the class
        //  itselt.
        WebDriverManager.chromedriver().setup(); // 4
        // Without #4, we have IllegalStateException
        ChromeDriver driver = new ChromeDriver(); // 2
        driver.manage().window().maximize(); // 5
        // maximize the window
        driver.get("http://google.com"); // 3

        // We want to navigate to the different page witin the same
        //  browser. We don't open a new browser or new tab.
        // URL can be passes as an object or as a String -> we use String.
        driver.navigate().to("http://amazon.com"); // 6

        // If I want to comeback to the previous page:
        driver.navigate().back(); // 7

        // If I want to know URL of current website:
        String url = driver.getCurrentUrl(); // 8
        System.out.println(url); // 9

        // Selenium cannot close browser automatically, so we use this:
        driver.close(); // 10

    }
}
