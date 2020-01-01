package tests.day9_Review; // two

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class LocatorsReview {

    private WebDriver driver; // 1

    @BeforeMethod // 3
    public void setup(){ // 2
        driver = BrowserFactory.getDriver("chrome"); // 4
        driver.get("http://practice.cybertekschool.com/"); // 5
    }


    // We have id, name, tag name, class name, link text, partial link text,
    //  xpath, css selector
    @Test(description = "Verify checkboxes") // 10
    public void test1(){ // 9
        driver.findElement(By.linkText("Checkboxes")).click(); // 11

        // [type='checkbox']:nth-of-type(1) -> since there are 2 elements
        //  with a same locator, and I need only the first one, so I can use
        //  in css: nth-of-type(index#). It's very useful if you have more
        //  than one element under same css selector.
        // Any tag or tag + attributes :nth-of-type(index#)
        WebElement checkbox1 = driver.findElement(By.cssSelector("[type='checkbox']:nth-of-type(1)")); // 12

        // How to verify if check box is not clicked?
        Assert.assertFalse(checkbox1.isSelected(), "Checkbox 1 was selected"); // 13
        // assert that checkbox is not selected

        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]")); // 14
        // //*[@type='checkbox'][2] -> also works the same
        // [index#] -> to specify index of the element, if there are multiple
        //  elements with this xpath.

        Assert.assertTrue(checkbox2.isSelected(), "Checkbox 2 was not selected"); // 15
        // css selector is preferable b.c of speed.
        // assertion is like "if statement".
        /*
                if(true){
                    "test passed"
                } else{
                    "test failed"
                           throw new RuntimeException ("Expected true but false")
                }
        */

        // -> Test passed
    }


    @Test(description = "Radio buttons test") // 17
    public void test2(){ // 16
        driver.findElement(By.linkText("Radio Buttons")).click(); // 18
        WebElement blueButton = driver.findElement(By.xpath("//*[text()='Blue']/preceding-sibling::input[@type='radio']")); // 19
        Assert.assertTrue(blueButton.isSelected(), "Blue button is not selected"); // 20
        // -> Test passed
    }

    @AfterMethod // 7
    public void teardown(){ // 6
        driver.quit(); // 8
    }
}
