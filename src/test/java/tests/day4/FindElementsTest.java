package tests.day4; // 102219 - one

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class FindElementsTest {
    public static void main(String[] args) { // 1
        WebDriver driver = BrowserFactory.getDriver("chrome"); // 2
        driver.get("http://practice.cybertekschool.com/forgot_password"); // 3

        // Test 1:
        // Once we opened the page, we have to capture the title.
        String expectedTitle = driver.getTitle(); //8
        // once we click the button, (after #5)

        // 1. Open Inspector in Chrome and find locator for the element.
        // 2. Create object of WebElement
        // 3. Use WebElement
        WebElement button = driver.findElement(By.id("form_submit")); // 4
        // Find element by ID.

        // To click on that element:
        button.click(); // 5

        // Read title again after clicking
        String actualTitle = driver.getTitle(); // 9
        // In this way, we make sure that after clicking, we stay on the
        //  same page.

        if (actualTitle.equals(expectedTitle)){ // 10
            System.out.println("Test passed"); // 11
        } else { // 12
            System.out.println("Test Failed"); // 13
            System.out.println("Expected title: "+ expectedTitle); // 14
            System.out.println("Actual title: "+actualTitle); // 15
            // Test passed
        }

        BrowserUtils.wait(2); // 6
        driver.close(); // 7

    }
}
