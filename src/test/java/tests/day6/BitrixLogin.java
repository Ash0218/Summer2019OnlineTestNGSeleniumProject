package tests.day6; // two

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class BitrixLogin {
    // ID: helpdesk59@cybertekschool.com
    // password: UserUser

    public static void main(String[] args) { // 1
        // getDriver() method returns object of webdriver. We need webdriver
        //  object to send commands to the browser. Left side is a reference
        //  variable to reuse this object. Object can be created and used
        //  without reference variable, but it's gonna be impossible to use
        //  that object more than once
        WebDriver driver = BrowserFactory.getDriver("chrome"); // 2

        // Go to BiTrix
        driver.get("https://login1.nextbasecrm.com/?login=yes"); // 3

        // Create XPATH by using name attribute
        // command + F -> type //input[@name='USER_LOGIN']


        // Enter email
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk59@cybertekschool.com"); // 4


        // Create XPATH by using palceholder
        // type //[@placeholder='Password']

        // Enter password
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("UserUser"); // 5
        // * -> matches any element. It's better to specify tag name, to avoid
        //  issues with finding element.

        // Create XPATH to Click Log In button
        // //input[@value='Log In']

        // Click on login button
        driver.findElement(By.xpath("//input[starts-with(@value, 'Log')]")).click(); // 6
        BrowserUtils.wait(3); // 7
        driver.quit(); // 8

        // Logged in the website with the given username and password



    }
}
