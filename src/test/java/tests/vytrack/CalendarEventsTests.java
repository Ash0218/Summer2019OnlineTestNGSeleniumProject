package tests.vytrack;// 112219     one

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.concurrent.TimeUnit;

public class CalendarEventsTests {

    private WebDriver driver; // 1
    private WebDriverWait wait; // 5

    @BeforeMethod // 3
    public void setup(){ // 2
        driver = BrowserFactory.getDriver("chrome"); // 4

        // Explicit wait
        wait = new WebDriverWait(driver, 10); // 6

        //Implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // 7

        // Maximize browser
        driver.manage().window().maximize(); // 8
        driver.get("https://qa1.vytrack.com/"); // 9
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85"); // 10
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER); // 11


        WebElement loaderMask = null; // 33

        if(driver.findElements(By.cssSelector("div[class='loader-mask shown']")).size() > 0){ // 34
            loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']")); // 35
            wait.until(ExpectedConditions.invisibilityOf(loaderMask)); // 36
        }


        WebElement activitiesElement = driver.findElement(By.linkText("Activities")); // 12
        // Activities -> from the website -> text=" Activities" (inspect)

        wait.until(ExpectedConditions.visibilityOf(activitiesElement)); // 13
        wait.until(ExpectedConditions.elementToBeClickable(activitiesElement)); // 14
        activitiesElement.click(); // 15

        WebElement calendarEventsElement = driver.findElement(By.linkText("Calendar Events")); // 16
        wait.until(ExpectedConditions.visibilityOf(calendarEventsElement)); // 17
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsElement)); // 18
        calendarEventsElement.click(); // 19


   //     WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']")); // 28
        wait.until(ExpectedConditions.invisibilityOf(loaderMask)); // 29
        // -> Test passed

    }


    @Test(description = "Verify page subtitle") // 24
    public void test1(){ // 23
        String expectedSubtitle = "All Calendar Events"; // 25
        String actualSubtitle = driver.findElement(By.className("oro-subtitle")).getText(); // 26
        // oro-subtitle -> indicates "All Calendar Events"

        Assert.assertEquals(actualSubtitle, expectedSubtitle, "Subtitle is wrong!"); // 27
        // If they don't match, the message will appear
        // -> Test failed -> loading issue
    }


    @Test(description = "Verify that 'Create Calendar event' button is displayed") // 31
    public void test2(){ // 30
        Assert.assertTrue(driver.findElement(By.cssSelector("[title='Create Calendar event']")).isDisplayed()); // 32
        // -> Test passed
    }


    @AfterMethod // 21
    public void teardown(){ // 20
        driver.quit(); // 22
    }
}
