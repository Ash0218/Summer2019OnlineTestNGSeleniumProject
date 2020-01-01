package tests.day7; // two

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class CssSelectorPractice {

    // which locator to use?
    // 1. id
    // 2. css
    // 3. xpath
    // 4. anything

    public static void main(String[] args) { // 1
        WebDriver driver = BrowserFactory.getDriver("chrome"); // 2
        driver.get("http://practice.cybertekschool.com/multiple_buttons"); // 3

        // Let's find all buttons, and click on them one by one.
        // Why I put . instead of space? b.c .btn.btn-primary -> are 2 class
        //  names. Each btn is each class name.
        // In this case, we will find all buttons that have class=
        //  ".btn.btn-primary" or [class='btn btn-primary']
        // . means class name, # means id
        List<WebElement> buttons = driver.findElements(By.cssSelector(".btn.btn-primary")); // 4

        // loops through list of buttons
        for (WebElement button: buttons){ // 5
            // and click on every button one by one
            button.click(); // 6
            BrowserUtils.wait(1); // 7

            // Get the message after click
            WebElement message = driver.findElement(By.cssSelector("#result")); // 8
            // #result is from the id of "Now it's gone!" message in the
            //  website.

            // Print the text of the message
            System.out.println(message.getText()); // 9

            // -> It clicked all the buttons
            // -> Now it's gone!
        }

        // Example for finding element using parent and child element in CSS selector:
        //  (find element with a tag name, h3 that has a parent element with
        //  class name, container)
        WebElement header = driver.findElement(By.cssSelector(".container > h3"));  // 11
        System.out.println(header.getText()); // 12
        // -> Multiple buttons

        WebElement p = driver.findElement(By.cssSelector("[class='container'] > p")); // 13
        // [class='container'] > p -> it is the paragraph under the ".container > h3" in #11
        System.out.println(p.getText()); // 14
        // -> Here are some examples of different buttons with different attributes:




        driver.quit(); // 10

    }
}
