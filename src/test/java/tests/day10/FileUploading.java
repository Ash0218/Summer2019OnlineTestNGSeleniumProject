package tests.day10; // two

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class FileUploading {

    private WebDriver driver; // 1

    @BeforeMethod // 2
    public void setup(){ // 3
        driver = BrowserFactory.getDriver("chrome"); // 4
        driver.get("http://practice.cybertekschool.com/"); // 5
    }


    @Test(description = "Verify that file was uploaded") // 10
    public void test1(){ // 9
        driver.findElement(By.linkText("File Upload")).click(); // 11
        driver.findElement(By.id("file-upload")).sendKeys("/Users/ashley/Desktop/111819FileUpload"); // 12
        // Provide path to the file.
        // "file-upload" -> from the practice website, File Upload -> inspect ->
        //  click "choose file" -> id
        // "/Users/ashley/Desktop/111819FileUpload" -> saved the file and
        //  got the path from the Terminal by drag and drop
        // Or right click while pressing "Option"
        // For windows: hold shift and right click

        driver.findElement(By.id("file-submit")).click(); // 13
        // click submit
        // "file-submit" -> click "Upload" -> id

        BrowserUtils.wait(4); // 14

        String expectedFileName = "111819FileUpload"; // 15
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText(); // 16

        Assert.assertEquals(actualFileName, expectedFileName); // 17
        // -> Test passed
    }


    @AfterMethod // 6
    public void teardown(){ // 7
        driver.quit(); // 8
    }
}
