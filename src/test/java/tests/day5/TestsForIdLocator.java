package tests.day5; // 102819  one

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class TestsForIdLocator {
    public static void main(String[] args) { // 1
        WebDriver driver = BrowserFactory.getDriver("chrome"); // 2
        driver.get("http://practice.cybertekschool.com/multiple_buttons"); // 3

        // id = "disappearing_button" -> from the web-page
        WebElement button = driver.findElement(By.id("disappearing_button")); // 4

        button.click(); // 5
        // button knows where is the id
        // click the "Don't click" button -> Now it's gone -> inspect

        WebElement result = driver.findElement(By.id("result")); // 6
        // <p id="result" style="color:green">Now it's gone!</p> -> from
        //  the web-page. Now it's gone -> the text which .getText() will
        //  return
        System.out.println(result.getText()); // 7
        // -> Now it's gone


        driver.quit(); // 4
    }
}
