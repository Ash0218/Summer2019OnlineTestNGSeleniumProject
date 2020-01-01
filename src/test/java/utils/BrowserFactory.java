package utils; // 102119 -> help to create driver easier

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    // Create a method that returns a driver object. This method will
    //  take one parameter - String browser. Based on the value of browser,
    //  parameter method will return corresponded webdriver object. If
    //  browser equals to Chrome, then return chromebrowser object.
    public static WebDriver getDriver(String browser){ // 1
        if (browser.equalsIgnoreCase("chrome")){ // 2
            WebDriverManager.chromedriver().setup(); // 3
            return new ChromeDriver(); // 4
            // from #1 - 4 will prepare a webdriver and give it to me.
        } else if (browser.equalsIgnoreCase("firefox")){ // 5
            WebDriverManager.firefoxdriver().setup(); // 6
            return new FirefoxDriver(); // 7
        }
        return null; // 8
        // reason for #8, if the both #2,5 don't work, then it must return
        //  something, or the method wouldn't compile.
    }
}
