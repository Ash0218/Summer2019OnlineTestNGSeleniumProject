package tests.day8_111419Vasya; // 111419   one

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.List;


public class RadioButtons {
   private WebDriver driver; // 3

    @BeforeMethod // 2
    public void setup(){ // 1
        driver = BrowserFactory.getDriver("chrome"); // 4
        driver.get("http://practice.cybertekschool.com/"); // 5

        // <a href="/radio_buttons">Radio Buttons</a> -> linkTexk
        // -> every element has a linkText, and the text btween <a> can
        //  be shown in the website. You can find the text, and it works
        //  only with <a> elements. linkText is only in between >Text<
        // Also, this step is common for all test cases -> that's why we
        //  put it here.
        // To go to Radio Buttons page:
        driver.findElement(By.linkText("Radio Buttons")).click(); // 11

    }

    @Test(description = "Verify that blue button is selected") // 10
    public void test1(){ // 9

       // find blue radio button
        WebElement blueButton = driver.findElement(By.id("blue")); // 12

        // Verify that radio button is selected:
        //  -> assertTrue that button is selected. If button is selected,
        //  it will return true, otherwise, fasle.
     //  Assert.assertTrue(blueButton.isSelected()); // 13
        // -> test passed

        // Instead of #13, you can use this:
        boolean isSelected = blueButton.isSelected(); // 14
        Assert.assertTrue(isSelected); // 15
        // -> test passed
        // assertTrue will expect that isSelected is true

    }


    @Test(description = "Verif that red button is not selected") // 17
    public void test2(){ // 16
        WebElement redButton = driver.findElement(By.id("red")); // 18
        Assert.assertFalse(redButton.isSelected()); // 19
        // to figure out if it is not selected, we used assertFalse, not
        //  assertTrue. (assertFalse will expect that condition is false)
        // -> Test passed
        // isSelected() will return true if the button is already clicked.
    }


    @Test(description = "Verify that green button is not clickable") // 21
    public void test3(){ // 20
        WebElement greenButton = driver.findElement(By.id("green")); // 22
        Assert.assertFalse(greenButton.isEnabled()); // 23
        // used assertFalse b.c we make sure that green button is NOT clickable
        // -> Test passed
        // isEnabled() will return true if button is available for interaction
        //  that means you can click on it, in this case.
    }


    // Find all radio buttons and click on them one by one
    @Test(description = "Click on all radio buttons") // 25
    public void test4(){ // 24
        // how to find all radio buttons? Any radio button will have
        //  type='radio' and input as an element type.
        List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type='radio']")); // 26
        // input[type='radio'] -> is from the website, Radio Buttons -> blue

        // Click only if button is not clicked and it is available for clicking
        for (WebElement button: radioButtons){ // 27

            // If button is available for clicking and not clicked yet,
            if (button.isEnabled() && !button.isSelected()){ // 28
                // then click it.
                button.click(); // 29

                // In this case, id attribute represents a name of the color.
                // <input type="radio" id="green" name="color" disabled=""> ->
                //  attribute = type, id, name, disabled
                System.out.println("Button clicked: " + button.getAttribute("id")); // 30
            } else { // 31
                System.out.println("Button was not clicked: " + button.getAttribute("id")); // 32
                /*
                Button was not clicked: blue -> b.c it was selected by default
                Button clicked: red
                Button clicked: yellow
                Button clicked: black
                Button was not clicked: green
                Button clicked: basketball
                Button clicked: football
                Button clicked: hockey
                Button clicked: water_polo
                 */


            }
        }

    }


    @AfterMethod // 7
    public void teardown(){ // 6
        driver.quit(); // 8
    }
}
