package tests.day4; // four

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class ReadAttributesTest {

    public static void main(String[] args) { // 1
        WebDriver driver = BrowserFactory.getDriver("chrome"); // 2
        driver.get("http://practice.cybertekschool.com/forgot_password"); // 3
        WebElement input = driver.findElement(By.name("email")); // 4

        // To read value of any attribute
        // name="email" -> name is an attribute, email is a value of attribute
        System.out.println(input.getAttribute("pattern")); // 5
        // pattern is from the website -> inspector
        // -> [a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$ -> this is the pattern
        // of the element.
        input.sendKeys("random_email@email.com"); // 7

        // How to read entered text?
        //  it's gonna be inside the value attribute
        System.out.println(input.getAttribute("value")); // 8
        // If button has a type "submit", we can use .submit() method instead
        //  of click() as well.
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit")); // 9

        // Alternative to click() only if type="submit"
        retrievePasswordButton.submit(); // 10
        // -> random_email@email.com

        driver.close(); // 6

    }
}
