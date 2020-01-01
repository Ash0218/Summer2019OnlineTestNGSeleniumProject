package tests.day8_111319Marufjon; // two

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class DisabledElementTest {

    @Test // 1
    public void test1(){ // 2
        WebDriver driver = BrowserFactory.getDriver("chrome"); // 3

        driver.get("http://practice.cybertekschool.com/radio_buttons"); // 4

        WebElement green = driver.findElement(By.id("green")); // 5
        // "green" -> from the website, Radio Buttons. The disabled button,
        //  green's id="green".

        System.out.println("Is element enabled: "+ green.isEnabled()); // 6

        green.click(); // 9
        // green button is not clicked -> blue is clicked (nothing happened)


        driver.get("http://practice.cybertekschool.com/dynamic_controls"); // 10
        WebElement input = driver.findElement(By.cssSelector("#input-example>input")); // 11

        System.out.println("Is element enabled: " + input.isEnabled()); // 12
        /*
        Is element enabled: false
        Is element enabled: false
         */

        input.sendKeys("to test if it is enabled"); // 13
        // -> ElementNotInteractableException -> failed










        BrowserUtils.wait(3); // 7

        driver.quit(); // 8
    }
}
