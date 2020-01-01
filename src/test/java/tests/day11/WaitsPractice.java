package tests.day11; // 111919      one

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class WaitsPractice {

    private WebDriver driver; // 1

    @BeforeMethod // 3
    public void setup(){ // 2
        driver = BrowserFactory.getDriver("chrome"); // 4
        driver.get("http://practice.cybertekschool.com/"); // 5

    }

    @Test // 10
    public void test1(){ // 9

        // This line should be before all findElement() methods.
        // To wait witnin 10 seconds, until element is present.
        // We apply it once, and it always works.
        // Put this line into @BeforeMethod, and it will work for all tests.
        // Example 2: Element on the page that is rendered after the trigger -> link text.
        // Example 2 -> only part of the link text. we can use partialLinkText
        //  locator to find element by partial text.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // 11

        driver.findElement(By.linkText("Dynamic Loading")).click(); // 13

        driver.findElement(By.partialLinkText("Example 2")).click(); // 14
        // partialLinkText(): we match only part of the link text. It is like
        // contains text.

        driver.findElement(By.tagName("button")).click(); // 15

        WebElement finishElement = driver.findElement(By.id("finish")); // 12
        // This is for "Hello World!"

        System.out.println(finishElement.getText()); // 16
        // -> Hello World!
    }


    @Test // 18
    public void test2(){ // 17
        driver.findElement(By.linkText("Dynamic Loading")).click(); // 19

       // Select Example #1 or XPATH: //a[contains(text(),'Example 1')]
        driver.findElement(By.partialLinkText("Example 1")).click(); // 20

       // Click on start button
        driver.findElement(By.tagName("button")).click(); // 21

        // Find element first, but the problem is element can be present,
        //  but not visible.
        WebElement userNameInputBox = driver.findElement(By.id("username")); // 24

        // ExplicitWait
        // We create object of WebDriverWait to apply explicit wait. We
        //  must provide webdriver object and period of time. Within this
        //  period of time, Selenium will check every 500 milliseconds.
        //  If the condition is true (if the condition met), then no need
        //  to wait longer. Your script will continue execution. In this
        //  case, the waiting time is 10 seconds.
        WebDriverWait wait = new WebDriverWait(driver, 10); // 23

        // How to apply condition or ExpectedConditions.condition
        // Here, Selenium WebDriver will wait up to 10 sec until element is visible. If
        //  wait time expire, then your test will fail (due to exception).
        wait.until(ExpectedConditions.visibilityOf(userNameInputBox)); // 25
        // wait until the element is visible.

        // Enter username
        userNameInputBox.sendKeys("tomsmith"); // 22
        // tomsmith -> entered into username box
        // fixed after #24
        // After #25, when it is visible, it applies

        WebElement passwordInputBox = driver.findElement(By.id("pwd")); // 26


        wait.until(ExpectedConditions.visibilityOf(passwordInputBox)); // 28
        passwordInputBox.sendKeys("SuperSecretPassword"); // 27

        // -> Test passed

        // This is a webelement that represents submit button
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']")); // 29

        // wait (within 10 sec) until that button is available for click
        wait.until(ExpectedConditions.elementToBeClickable(submit)); // 30

        submit.click(); // 31

        WebElement message = driver.findElement(By.tagName("h4")); // 32

        wait.until(ExpectedConditions.visibilityOf(message)); // 35
        // it can wait until 10 sec when there is some exception or error and takes
        //  more time.

        String expectedMessage = "Welcome to the Secure Area. When you are done click logout below."; // 33
        String actualMessage = message.getText(); // 34

        Assert.assertEquals(actualMessage, expectedMessage); // 35
        // -> Test passed
    }


    @Test // 37
    public void test3(){ // 36
        driver.findElement(By.linkText("Dynamic Loading")).click(); // 38
        driver.findElement(By.partialLinkText("Example 5")).click(); // 39
        WebDriverWait wait = new WebDriverWait(driver, 15); // 40
        WebElement overlayScreen = driver.findElement(By.cssSelector("[class='fa fa-cog fa-spin']")); // 41

        // Wait until overlay screen disappear. Otherwise, we will have issue
        //  to click or enter the text.
        wait.until(ExpectedConditions.invisibilityOf(overlayScreen));  // 42

        // Find Webelement of user input box
        WebElement userNameInputBox = driver.findElement(By.id("username")); // 43

        // wait for user name input box to become visible
        wait.until(ExpectedConditions.visibilityOf(userNameInputBox)); // 44

        // Enter user name
        userNameInputBox.sendKeys("tomsmith"); // 45

        // find webelement of password input box
        WebElement passwordInputBox = driver.findElement(By.id("pwd")); // 46

        // wait for password input box to become visible
        wait.until(ExpectedConditions.visibilityOf(passwordInputBox)); // 47
        passwordInputBox.sendKeys("SuperSecretPassword"); // 48

        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']")); // 49
        wait.until(ExpectedConditions.elementToBeClickable(submit)); // 50

        submit.click(); // 51


        WebElement message = driver.findElement(By.tagName("h4")); // 52

        wait.until(ExpectedConditions.visibilityOf(message)); // 53

        String expectedMessage = "Welcome to the Secure Area. When you are done click logout below."; // 54
        String actualMessage = message.getText(); // 55

        Assert.assertEquals(actualMessage, expectedMessage); // 56

        // -> Test passed

    }

/*
    @Test(description = "Fluent wait example") // 58
    public void test4(){ // 57
        driver.findElement(By.linkText("Dynamic Loading")).click(); // 59
        driver.findElement(By.partialLinkText("Example 2")).click(); // 60
        driver.findElement(By.tagName("button")).click(); // 65

        Wait wait = new FluentWait(driver) // 61
                .withTimeout(Duration.ofSeconds(10)); // 62
                .pollingEvery(Duration.ofMillis(200)); // 63
                .ignoring(ElementNotVisibleException.class); // 64
        WebElement message = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("finish"));
            }
        }
        );

    }

    private void ignoring(Class<ElementNotVisibleException> elementNotVisibleExceptionClass) {

    }

    private void pollingEvery(Duration ofMillis) {
    }
*/
    @AfterMethod // 8
    public void teardown(){ // 6
        driver.quit(); // 7
    }

}


