package tests.day7; // three

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestNGPractice { // click the green arrow -> run all tests

    @Test // 2
    // #2 should be on the top of the public void method (#1)
    public void test(){ // 1

        // To verify that expected and actual result is the same.
        // If no - it will throw exception and stop the program.
        // Also, you will see in the console what was expected and what
        //  was actual.
        Assert.assertEquals("appl", "apple", "Word is not correct! Should be apple"); // 2
        // command + click 'assertEquals' -> shows Assert.class info.
        // -> click "download sources" if it appears on the top
        // #2 -> Word is not correct! Should be apple


        /*
        Before we use Assertion:

            if (str.equals(str2)){
                System.out.println("passed");
            } else {
                System.out.println("Test failed");
            }

         */
    }

    @Test (description = "Verifying title of the practice website")// 4
    public void verifyTitle(){ // 3
        WebDriver driver = BrowserFactory.getDriver("chrome"); // 5
        driver.get("http://practice.cybertekschool.com/"); // 6
        String expectedTitle = "Practice"; // 7
        String actualTitle = driver.getTitle(); // 8
        Assert.assertEquals(actualTitle, expectedTitle, "Title is wrong"); // 9
        // message appears when there is an error

        BrowserUtils.wait(3); // 11
        driver.quit(); // 10
    }

    // Let's verify that Test Automation Practice heading is displayed
    @Test(description = "verify that heading is displayed") // 13
    public void verifyHeadingIsDisplayed(){ // 12
        WebDriver driver = BrowserFactory.getDriver("chrome"); // 13
        driver.get("http://practice.cybertekschool.com/"); // 14

       // If there is no element with this locator, we will get NoSuchElementException
        //  and our program will stop on the findElement line.
        WebElement heading = driver.findElement(By.xpath("//span[text()='Test Automation Practice']")); // 15
        // //span[text()='Test Automation Practice -> to find heading of
        //  the website, http://practice.cybertekschool.com/ -> Inspect ->
        //  clcik "Test Automation Practice -> type //span[text()='Test Automation Practice
        //  The locator is XPATH

        // To make sure that element is visible to user b.c element can be
        //  present, but not visible -> we need to make sure element is
        //  visible (it will be printed if there is element, but not visible).
        // AssertTrue - method that checks if something is true. If it's false,
        //  you will get exception.
        // .isDisplayed() a method that returns true or false. If it returns true -> element is
        //  visible. If it returns false -> element is not visible.
        Assert.assertTrue(heading.isDisplayed(), "Element is not visible"); // 16

        BrowserUtils.wait(3); // 17
        driver.quit(); // 18

        // If the lower left part is all green (Default, Summer.. -> the
        //  packages)-> everything is fine.
    }










}
