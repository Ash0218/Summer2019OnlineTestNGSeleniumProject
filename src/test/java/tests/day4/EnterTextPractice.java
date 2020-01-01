package tests.day4; // two

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class EnterTextPractice {

    public static void main(String[] args) { // 1
     // Task:
     // Find the element by name and insert 'random@email.com" into
     //  the email-box of the webpage.

        // Gray text "browser" is not a value. It's a placeholder/ name of
        //  the method parameter. You don't enter that it comes up
        //  automatically.
        WebDriver driver = BrowserFactory.getDriver("chrome"); // 2
        // Go to the page
        driver.get("http://practice.cybertekschool.com/forgot_password"); // 3
        // Let the driver find the element by name. The name, email is found
        //  from the web page using inspector
        WebElement inputBox = driver.findElement(By.name("email")); // 4
        // Enter "random@email.com" in the input box of the website
        inputBox.sendKeys("random@email.com"); // 5
        // Find the element by id (find the button to click and send the
        //  random@email.com.
        WebElement button = driver.findElement(By.id("form_submit")); // 6
        // To click on the element
        button.click(); // 7


    // Test2: Verify that email changed
        /*
        Go to "http://practice.cybertekschool.com/forgot_password"
        Enter any valid email
        Click on retrieve password button
        Verify that URL is equals to "http://practice.cybertekschool.com/email_sent"

         */
        String expectedURL = "http://practice.cybertekschool.com/email_sent"; // 10
        String actualURL = driver.getCurrentUrl(); // 11
        if (expectedURL.equals(actualURL)){ // 12
            System.out.println("Test passed"); // 13
        } else{ // 14
            System.out.println("Test failed"); // 15
        } // -> Test passed


        // Make the browser wait for 2 seconds
        BrowserUtils.wait(2); // 8
        // close the browser
        driver.close(); // 9

    }
}
