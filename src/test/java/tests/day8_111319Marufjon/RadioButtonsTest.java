package tests.day8_111319Marufjon; // 111319    one

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class RadioButtonsTest {

    @Test // 1
    public void test1(){ // 2

        WebDriver driver = BrowserFactory.getDriver("chrome"); // 3

        driver.get("http://practice.cybertekschool.com/radio_buttons"); // 4

        WebElement blue = driver.findElement(By.id("blue")); // 5
      //  WebElement blue = driver.findElement(By.id("bsslue")); // 7
        // -> NoSuchElementException

        WebElement red = driver.findElement(By.id("red")); // 6


        System.out.println("is blue selected: " + blue.isSelected()); // 10

     //   System.out.println("is blue selected: " + !blue.isSelected()); // 14
        /*
        is blue selected: false
        is red selected: false
         */

        System.out.println("is red selected: " + red.isSelected()); // 11
        // To verify if radio buttons (red, blue) are selected or not.
        /* ->
        is blue selected: true
        is red selected: false

        When I went to the page, blue is already selected. Only one can be
        selected -> other colors would be false automatically.
         */


        // Verify if blue is selected?
        Assert.assertTrue(blue.isSelected()); // 12
        // Assert if blue is selected method -> returns true (#12 tests).

     //   Assert.assertTrue(!blue.isSelected()); // 13
        // -> Test failed


        // Verify if red is not selected?
        Assert.assertFalse(red.isSelected()); // 15
        /*
        is blue selected: true
        is red selected: false
         */

        System.out.println("Clicking on red"); // 16
        /*
        is blue selected: true
        is red selected: false
        Clicking on red
         */

        red.click(); // 17
        System.out.println("is blue selected: " + blue.isSelected()); // 18
        System.out.println("is red selected: " + red.isSelected()); // 19
        /*
        is blue selected: false
        is red selected: true
         */


        // Verify blue is NOT selected:
        Assert.assertFalse(blue.isSelected()); // 20


        // Verify red is selected:
        Assert.assertTrue(red.isSelected()); // 21











        BrowserUtils.wait(3); // 8

        driver.quit(); // 9


    }
}
