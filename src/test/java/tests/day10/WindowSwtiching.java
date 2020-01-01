package tests.day10; // 111819      one

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.Set;

public class WindowSwtiching {
    private WebDriver driver; // 1

    @BeforeMethod // 3
    public void setup(){ // 2
        driver = BrowserFactory.getDriver("chrome"); // 4
        driver.get("http://practice.cybertekschool.com/"); // 5
        driver.manage().window().maximize(); // 15
    }

    @Test(description = "Verify that title is still Practice") // 10
    public void test1(){ // 9
        driver.findElement(By.linkText("New tab")).click(); // 11

       // After 3 seconds, another website will be opened in the second
        // window. Selenium doesn't switch automatically to the new window.
        BrowserUtils.wait(5); // 12
        System.out.println(driver.getTitle()); // 13
        // -> Test passed
        // -> Practice

        Assert.assertEquals(driver.getTitle(), "Practice", "Title is wrong!"); // 14
        // -> Test (assert) passed
        // If the title is not Practice, then the message, "Title is wrong"
        //  will appear

    }


    @Test(description = "Verify that user is able to see new window") // 16
    public void test2(){ // 15
        driver.findElement(By.linkText("New tab")).click(); // 17

        // record id of original window that we opened initially.
        String oldWindow = driver.getWindowHandle(); // 19
        BrowserUtils.wait(5); // 18
        // In the selenium, every window has an id. That id calls window handle.
        //  To read window handle we use method getWindowHandle() -> #19
        // After new window was opened, we can get list of all window ids
        // list - it's a data structure
        // set - it's also a data structure, but it doesn't allow duplicates
        //  also, you cannot easily access anything from there. There is no
        //  .get() method. That's why we need to loop through the set, to
        //  read a data from there.

        // Set can store only unique values.
        Set<String> windowHandles = driver.getWindowHandles(); // 20

        // loop through the collection of window handles
        for (String windowHandle : windowHandles){ // 21
            if (!windowHandle.equals(oldWindow)){ // 22
                // if it's not an old window,
                driver.switchTo().window(windowHandle); // 23
                // then switch to that window
            }
        }

        // Verify that title of the new window is a Fresh tab
        System.out.println(driver.getTitle()); // 24
        Assert.assertEquals(driver.getTitle(), "Fresh tab", "Title is wrong!"); // 25
        // -> Test passed
        // -> Fresh tab

        // Comeback to original page -> we can build a function that will
        //  jump in between windows based on page title.
        String pageTitle = "Practice"; // 28
        // Title of the page that we want

        for (String windowHandle : windowHandles){ // 26
            driver.switchTo().window(windowHandle); // 27
            // keep jumping from window to window

            if (driver.getTitle().equals(pageTitle)){ // 29
                // once we found the correct page title,

                break; // 30
                // just exit and stop jumping.
            }
        }

        System.out.println(driver.getTitle()); // 31
        // -> Fresh tab
        // -> Practice
        // Test passed


    }

    @AfterMethod // 7
    public void teardown(){ // 6
        driver.quit(); // 8
    }

}
