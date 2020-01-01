package tests.day12; // two

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class ActionsClassHoverPractice {

    private WebDriver driver; // 1

    @BeforeMethod // 3
    public void setup(){ // 2
        driver = BrowserFactory.getDriver("chrome"); // 4
        driver.get("http://practice.cybertekschool.com/hovers"); // 5

    }


    @Test(description = "Verify first image") // 10
    public void test1(){ // 9

        // Create object of actions class to perform actions (drag and
        //  drop, context click, move to specific point, etc..)
        Actions action = new Actions(driver); // 11

        WebElement image1 = driver.findElement(By.cssSelector(".figure:nth-of-type(1)")); // 12
        // or use [class='figure']:nth-of-type(1) -> nth means 8th, 7th, 4th child, ...
        // 2:4:29

        // Just to hover on element, not click
        // Without .perform(), it will not work. (.perform() triggers actions)
        // moveToElement = hover
        action.moveToElement(image1).perform(); // 13
        // build() is required when we have more
        //  than 1 action in a chain.

        BrowserUtils.wait(3); // 14
        // for demo
        // -> Test passed

        // h5 is a grand child of .figure:nth-of-type(1) that contains image.
        WebElement textOfImageElement = driver.findElement(By.cssSelector(".figure:nth-of-type(1) h5")); // 15

        String expectedText = "name: user1"; // 16
        String actualText = textOfImageElement.getText(); // 17

        Assert.assertEquals(actualText, expectedText); // 18
        // -> Test passed

    }



    @Test(description = "Verify all images") // 20
    public void test2(){ // 19
        Actions action = new Actions(driver); // 21
        for (int i = 1; i <= 3; i++){ // 22
            action.moveToElement(driver.findElement(By.cssSelector(".figure:nth-of-type(" + i + ")"))).perform(); // 23
            BrowserUtils.wait(3); // 24
            // I don't know why but if you put 2 in #24, then test fails

            String name = driver.findElement(By.cssSelector(".figure:nth-of-type(" + i + ") h5")).getText(); // 25
            System.out.println(name); // 26
            // name: user1
            // name: user2
            // name: user3
            // -> Test passed

            Assert.assertEquals(name, "name: user"+i); // 27
        }
    }

    @AfterMethod // 7
    public void teardown(){ // 6
        driver.quit(); // 8
    }
}
