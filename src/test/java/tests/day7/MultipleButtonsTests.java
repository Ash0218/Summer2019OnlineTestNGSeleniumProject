package tests.day7; // five

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class MultipleButtonsTests {
    private WebDriver driver; // 1

    @BeforeMethod // 3
    public void setUp(){ // 2
        driver = BrowserFactory.getDriver("chrome"); // 4
        driver.get("http://practice.cybertekschool.com/multiple_buttons"); // 5
    }

    @Test // 10
    public void verifyButton1(){ // 9
        String expectedResult = "Clicked on button one!"; // 11
        driver.findElement(By.xpath("//*[text()='Button 1']")).click(); // 12
        String actualResult = driver.findElement(By.cssSelector("#result")).getText(); // 13
        // "result": Multiple Buttons website -> Inspect -> click "Clicked on button one!"
        //  -> id="result"

        Assert.assertEquals(actualResult, expectedResult, "Result is wrong!"); // 14

    }


    @Test // 20
    public void verifyButton2(){ // 15
        String expectedResult = "Clicked on button two!"; // 16
        driver.findElement(By.name("button2")).click(); // 17
        String actualResult = driver.findElement(By.cssSelector("#result")).getText(); // 18
        // "result": Multiple Buttons website -> Inspect -> click "Clicked on button two!"
        //  -> id="result"

        Assert.assertEquals(actualResult, expectedResult, "Result is wrong!"); // 19

    }



    @AfterMethod // 7
    public void teardown(){ // 6
        driver.quit(); // 8
    }
}
