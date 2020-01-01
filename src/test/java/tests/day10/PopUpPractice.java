package tests.day10; // three

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class PopUpPractice {

    private WebDriver driver; // 1


    @BeforeMethod // 2
    public void setup(){ // 3
        driver = BrowserFactory.getDriver("chrome"); // 4
        driver.get("http://practice.cybertekschool.com/"); // 5
    }


    @Test(description = "Click on button 1 and click OK in pop up message") // 6
    public void test1(){ // 7
        driver.findElement(By.linkText("JavaScript Alerts")).click(); // 8
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click(); // 9
        BrowserUtils.wait(2); // 10

        // To deal with popup, we can create object of Alert.
        // It switches to the currently active modal dialog
        Alert alert = driver.switchTo().alert(); // 11
        // Alert is an interface, so to use this, we need .switchTo().alert()

        // To click OK:
        alert.accept(); // 12
        BrowserUtils.wait(2); // 13


    }


    @Test(description = "Click on button 2 and cancel in pop up message") // 17
    public void test2(){ // 18
        driver.findElement(By.linkText("JavaScript Alerts")).click(); // 19

        // [2] means second button out of available, since there are 3 buttons
        driver.findElement(By.xpath("//button[2]")).click(); // 20
        BrowserUtils.wait(2); // 21
        Alert alert = driver.switchTo().alert(); // 22

        // Print text of pop up message:
        System.out.println(alert.getText()); // 25

        // To click cancel:
        alert.dismiss(); // 23
        BrowserUtils.wait(2); // 24

        // To print text of result:
        System.out.println(driver.findElement(By.id("result")).getText()); // 25
        // -> I am a JS Confirm
        // -> You clicked: Cancel
    }


    @Test(description = "Click on button 3, enter some text and then click OK") // 27
    public void test3(){  // 26
        driver.findElement(By.linkText("JavaScript Alerts")).click(); // 28
        driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click(); // 29
        BrowserUtils.wait(2); // 30
        driver.switchTo().alert().sendKeys("Java is fun!"); // 31
        BrowserUtils.wait(2); // 34
        driver.switchTo().alert().accept(); // 32
        // To print text of result: (it should be "Java is fun!")
        System.out.println(driver.findElement(By.id("result")).getText()); // 33
        BrowserUtils.wait(2); // 35
        // -> You entered: Java is fun!
    }


    @AfterMethod // 14
    public void teardown(){ // 15
        driver.quit(); // 16
    }
}
