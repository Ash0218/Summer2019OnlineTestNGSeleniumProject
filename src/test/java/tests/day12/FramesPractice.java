package tests.day12; // 112119      one

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class FramesPractice {

    private WebDriver driver; // 1


    @BeforeMethod // 3
    public void setup(){ // 2
        driver = BrowserFactory.getDriver("chrome"); // 4
        driver.get("http://practice.cybertekschool.com/frames"); // 5
    }


    @Test(description = "iFrame example") // 10
    public void test1(){ // 9
        driver.findElement(By.linkText("iFrame")).click(); // 11

        // Since element inside a frame, element is not visible for selenium
        //  without switching to the frame.
        // we can swtich to frame based on id, name, index (starting from 0),
        //  web element.
        driver.switchTo().frame("mce_0_ifr"); // 16
        // "mce_0_ifr" -> it is from <iframe id=> of the website
        // hold command and click frame in #16 -> you can see the explanation
        // Without swtiching, we can't see inner HTML document.
        // Which one to use? id, name, index, webelement?
        //  1. id or name   <iframe id="mce_0_ifr" name="some_frame">
        //  2. webelement driver.findElement(By.cssSelector("iframe[class='some_frame']"));
        //  3. index [iframe1, iframe2, iframe3...]

        WebElement inputArea = driver.findElement(By.id("tinymce")); // 12

        String expectedText = "Your content goes here."; // 13
        String actualText = inputArea.getText(); // 14
        Assert.assertEquals(actualText, expectedText); // 15
        // -> NoSuchElementException -> failed Test

        BrowserUtils.wait(4); // 18

        inputArea.clear(); // 19
        // delete text

        BrowserUtils.wait(4); // 20
        inputArea.sendKeys("Java is fun!"); // 21
        // -> Test passed

        // To exit from the frame
        driver.switchTo().defaultContent(); // 17
        // -> Test passed

    }

    // In case of nested frames, we must swtich to the first frame -> then
    //  again to another frame, that is inside
    // --html
    // --frame #1
    // ---- frame #2
    @Test(description = "Nested Frames example") // 23
    public void test2(){ // 22

        // it's not swtich to frame, nor a navigation action.
        driver.findElement(By.linkText("Nested Frames")).click(); // 24

        // We swtich to frame based on webelement
        driver.switchTo().frame(driver.findElement(By.cssSelector("[name='frame-bottom']"))); // 25
        // the reason why we are switching here is b.c content that is inside
        //  a frame is not visible for selenium. It's like when you are the first
        //  floor trying to find what is on the second floor.

        WebElement content = driver.findElement(By.tagName("body")); // 26
        System.out.println(content.getText()); // 27
        // -> BOTTOM

        driver.switchTo().defaultContent(); // 28
        // to exit from all frames, go to first floor

        driver.switchTo().frame("frame-top"); // 29
        // second floor

        driver.switchTo().frame("frame-left"); // 30
        // third floor

        System.out.println(driver.findElement(By.tagName("body")).getText()); // 31
        // print text
        // -> BOTTOM
        // -> LEFT
    }

    @AfterMethod // 7
    public void teardown(){ // 6
        driver.quit(); // 8
    }
}
