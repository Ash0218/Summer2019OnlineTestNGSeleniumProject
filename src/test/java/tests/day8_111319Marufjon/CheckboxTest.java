package tests.day8_111319Marufjon; // three

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class CheckboxTest {

    @Test // 1
    public void test(){ // 2
        WebDriver driver = BrowserFactory.getDriver("chrome"); // 3
        driver.get("http://practice.cybertekschool.com/checkboxes"); // 4

        WebElement one = driver.findElement(By.xpath("//input[1]")); // 5
        // checkbox 1

        WebElement two = driver.findElement(By.xpath("//input[2]")); // 6
        // checkbox 2

        System.out.println("One is selected: " + one.isSelected()); // 7
        System.out.println("Two is selected: " + two.isSelected()); // 8
        // -> One is selected: false
        // -> Two is selected: true
        // By default, the first one is automatically selected.



        // Verify one is not selected:
        Assert.assertFalse(one.isSelected()); // 11

        // Verify two is selected:
        Assert.assertTrue(two.isSelected()); // 12

        System.out.println("check the first one"); // 13
        one.click(); // 14

        System.out.println("One is selected: " + one.isSelected()); // 15
        System.out.println("Two is selected: " + two.isSelected()); // 15


        // Verify that one is selected:
        Assert.assertTrue(one.isSelected()); // 16

        // Verify that two is selected:
        Assert.assertTrue(two.isSelected()); // 17
        // One is selected: true
        // Two is selected: true

        System.out.println("uncheck the first one"); // 18
        one.click(); // 19

        System.out.println("One is selected: " + one.isSelected()); // 20
        System.out.println("Two is selected: " + two.isSelected()); // 20
        // uncheck the first one
        // One is selected: false
        // Two is selected: true


        // Verify that one is not selected
        Assert.assertFalse(one.isSelected()); // 21

        // Verify that two is selected
        Assert.assertTrue(two.isSelected()); // 22






        BrowserUtils.wait(3); // 9

        driver.quit(); // 10


    }
}
