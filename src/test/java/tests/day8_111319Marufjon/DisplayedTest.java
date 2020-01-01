package tests.day8_111319Marufjon; // six

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class DisplayedTest {

    @Test // 1
    public void test(){ // 2

        WebDriver driver = BrowserFactory.getDriver("chrome"); // 3
    //    driver.get("http://practice.cybertekschool.com/radio_buttons"); // 4

        // Find if 'blue' is displayed in different page:
   //     driver.get("http://practice.cybertekschool.com/"); // 7
        // -> test failed

        driver.get("http://practice.cybertekschool.com/dynamic_loading/1"); // 8


     //   WebElement blue = driver.findElement(By.id("blue")); // 5

        // Verify Element is Displayed
        WebElement home = driver.findElement(By.linkText("Home")); // 10
        Assert.assertTrue(home.isDisplayed()); // 11
        // -> test failed
        // element exists, but it's not on the screen

        // Verify Element not Displayed
        WebElement blue = driver.findElement(By.id("username")); // 9


        // Verify if element is displayed on the screen, verify if it is visible.
        Assert.assertTrue(blue.isDisplayed()); // 6










        BrowserUtils.wait(3);
        driver.quit();



    }
}
