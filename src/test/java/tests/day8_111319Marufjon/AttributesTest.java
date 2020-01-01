package tests.day8_111319Marufjon; // five

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class AttributesTest {

    @Test // 1
    public void test() { // 2

        WebDriver driver = BrowserFactory.getDriver("chrome"); // 3
        driver.get("http://practice.cybertekschool.com/radio_buttons"); // 4

        WebElement blue = driver.findElement(By.id("blue")); // 5

        // Get the value of attribute "name"
        System.out.println(blue.getAttribute("name")); // 6
        // -> color

        // Get the value of attribute "id"
        System.out.println(blue.getAttribute("id")); // 7
        // -> blue

        // we get null if the element does not have that attribute
        System.out.println(blue.getAttribute("href")); // 8
        // -> null


        // it gives empty String
        System.out.println(blue.getAttribute("class")); // 9
        // ->
        // Nothing appears -> empty

        // it returns true/ false
        System.out.println(blue.getAttribute("checked")); // 10
        // -> true

        // it returns the html information of that element
        System.out.println(blue.getAttribute("outerHTML")); // 11
        // -> <input type="radio" id="blue" name="color" checked="">

        // returns the text of the element (in certain cases)
        System.out.println(blue.getAttribute("value")); // 13
        // -> on

        // returns the text of element (in certain cases)
        System.out.println(blue.getAttribute("innerHTML")); // 12







        BrowserUtils.wait(3);
        driver.quit();
    }
}
