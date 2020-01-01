package tests.day4; // three

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class EnterTextPractice2 {
    /*
    Test3, Verify that confirmation message is displayed
    Go to "http://practice.cybertekschool.com/forgot_password"
    Enter any valid email
    Click on retrieve password button
    Verify that message “Your e-mail’s been sent!” is displayed

     */

    public static void main(String[] args) { // 1
        // Starting from driver setup
        WebDriver driver = BrowserFactory.getDriver("chrome"); // 2
        driver.get("http://practice.cybertekschool.com/forgot_password"); // 3
        WebElement input = driver.findElement(By.name("email")); // 4
        // Keys.ENTER will simulate ENTER button pressed
        input.sendKeys("random@email.com", Keys.ENTER); // 5
        WebElement confirmationMessage = driver.findElement(By.name("confirmation_message")); // 6
        String expectedMessage = "Your e-mail's been sent!"; // 7

        // To get the text from element
        String actualMessage = confirmationMessage.getText(); // 8
        if(expectedMessage.equals(actualMessage)){ // 9
            System.out.println("Test passed"); // 10
        } else { // 11
            System.out.println("Test failed"); // 12
        } // -> Test passed

        driver.close(); // 13



    }




}
