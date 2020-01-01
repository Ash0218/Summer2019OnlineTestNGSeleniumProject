package tests.day5; // five

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class TestsForLinkText {

    public static void main(String[] args) throws InterruptedException { // 1

        WebDriver driver = BrowserFactory.getDriver("chrome"); // 2

        driver.get("http://practice.cybertekschool.com/"); // 3

        // <a href="/autocomplete">Autocomplete</a>
        // Autocomplete -> the text that you see on the website before
        //  click inspect (the link where navigates you specified in href)
        // It works only if tag name is <a>
        // If you want to use LinkText or PartialLinkText locator, element
        //  must start with <a> -> specify link in HTML.
        driver.findElement(By.linkText("Autocomplete")).click(); // 4
        // It went to the "Autocomplete" page



        Thread.sleep(3000); // 5


        // Partial Link Text
       driver.navigate().back(); // 7
        // it went back to the previous page.

        WebElement link2 = driver.findElement(By.partialLinkText("Drag")); // 9

        link2.click(); // 10
        // it went to the "Drag and Drop" page.

        Thread.sleep(3000);






        Thread.sleep(3000); // 8
        // Added Exception in #1


        driver.quit(); // 6

    }
}
