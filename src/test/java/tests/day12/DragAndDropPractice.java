package tests.day12; // three

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class DragAndDropPractice {

    @Test(description = "Drag and drop example") // 2
    public void test1(){ // 1
        WebDriver driver = BrowserFactory.getDriver("chrome"); // 3
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index"); // 4
        driver.manage().window().maximize(); // 12

        BrowserUtils.wait(3); // 14
        // -> Test passed

        // Clcik on "accept cookies"
        driver.findElement(By.cssSelector("button[title='Accept Cookies']")).click(); // 13

        Actions actions = new Actions(driver); // 5

        WebElement moon = driver.findElement(By.id("draggable")); // 6
        // moon: draggable object (small ball)
        WebElement earth = driver.findElement(By.id("droptarget")); // 7
        // earth: target, where we want to drop draggable object (big ball)

        BrowserUtils.wait(3); // 9
        actions.dragAndDrop(moon, earth).perform(); // 8
        BrowserUtils.wait(3); // 10

        driver.quit(); // 11
    }
}
