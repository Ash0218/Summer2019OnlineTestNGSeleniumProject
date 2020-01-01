package tests.day5; // four

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestsForTagNameLocator {

    public static void main(String[] args) { // 1
        WebDriver driver = BrowserFactory.getDriver("chrome"); // 2


        driver.manage().window().maximize(); // 3
        driver.get("http://practice.cybertekschool.com/sign_up"); // 4

        // If you want to do in one line, without creating WebElement
        //  reference variable
        // Enter full name
        driver.findElement(By.name("full_name")).sendKeys("Test User"); // 5
        // full_name -> from the web-page, Test User -> I put it

        // Enter email
        driver.findElement(By.name("email")).sendKeys("test_email@email.com"); // 6
        // email -> from the web-page, test_email@email.com -> I put it

        // click sign-up
        driver.findElement(By.name("wooden_spoon")).click(); // 7

        BrowserUtils.wait(3); // 9
        // pause for 3 seconds


        WebElement sub_header = driver.findElement(By.tagName("h3")); // 10
        // h3 -> Thank you for signing up. Click the button below to return to the home page.
        //  -> it should be appeared

        System.out.println(sub_header.getText()); // 11
        // -> Thank you for signing up. Click the button below to return to the home page.

        driver.quit(); // 8
    }
}
