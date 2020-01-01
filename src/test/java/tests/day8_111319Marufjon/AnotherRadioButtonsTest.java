package tests.day8_111319Marufjon; // four

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class AnotherRadioButtonsTest {
    @Test // 1
    public void test(){ // 2

    WebDriver driver = BrowserFactory.getDriver("chrome"); // 3
        driver.get("http://practice.cybertekschool.com/radio_buttons"); // 4

        WebElement basketball = driver.findElement(By.id("basketball")); // 5
        WebElement football = driver.findElement(By.id("football")); // 6


        // Verify if both radio buttons are not selected
        Assert.assertFalse(basketball.isSelected()); // 7
        Assert.assertFalse(football.isSelected()); // 8






        BrowserUtils.wait(3);
        driver.quit();

    }
}
