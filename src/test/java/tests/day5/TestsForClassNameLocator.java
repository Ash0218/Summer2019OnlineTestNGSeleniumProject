package tests.day5; // three

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestsForClassNameLocator {

    public static void main(String[] args) { // 1

        WebDriver driver = BrowserFactory.getDriver("chrome"); // 2

        driver.get("http://practice.cybertekschool.com/multiple_buttons"); // 3

        // <h3 class="h3">Multiple buttons</h3>
        // h3 - it's a class name, or value of class attribute
        // If class has text with a space -> it is 2 class values
        WebElement heading = driver.findElement(By.className("h3")); // 5

        // read the text of attribute
        System.out.println(heading.getText()); // 6
        // -> Multiple buttons

        BrowserUtils.wait(3); // 7

        driver.close(); // 4

    }
}
