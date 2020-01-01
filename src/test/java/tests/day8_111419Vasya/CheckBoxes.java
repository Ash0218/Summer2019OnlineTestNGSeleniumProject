package tests.day8_111419Vasya; // two

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.List;

public class CheckBoxes {

    // command + option + L - to organize code
    private WebDriver driver; // 1
    // private b.c it will be used only in this class.

    @BeforeMethod // 2
    public void setup(){ // 3
        driver = BrowserFactory.getDriver("chrome"); // 4
        driver.get("http://practice.cybertekschool.com/"); // 5
        driver.findElement(By.linkText("Checkboxes")).click(); // 6
    }


    @Test // 11
    public void test1(){ // 10
       // Find all check boxes. Any check box will have [type='checkbox'].
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type='checkbox']")); // 12
        /*
        <form id="checkboxes">
        <input type="checkbox"> checkbox 1
        <br>
        <input type="checkbox" checked=""> checkbox 2
      </form>
         */

        int index = 1; // 19
        for (WebElement checkbox : checkboxes){ // 1
            if (checkbox.isEnabled() && !checkbox.isSelected()) { // 14
                checkbox.click(); // 15
                System.out.println("Checkbox clicked: "+ index); // 16

            } else { // 17
                System.out.println("Checkbox was not clicked: "+ index); // 17
                /*
                Checkbox clicked: 1
                Checkbox was not clicked: 2

                 checkbox 2 was not clicked b.c by default, it was already
                 clicked.
                 */

            }
            index++; // 20
        }
    }


    @AfterMethod // 8
    public void teardown(){ // 7
        driver.quit(); // 9

    }
}
