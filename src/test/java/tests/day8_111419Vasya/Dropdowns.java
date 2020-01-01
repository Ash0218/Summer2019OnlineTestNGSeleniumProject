package tests.day8_111419Vasya; // three

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class Dropdowns {
    private WebDriver driver; // 1

// <select id="dropdown">
//      <option value="" disabled="disabled" selected="selected">Please select an option</option>
//      <option value="1">Option 1</option>
//      <option value="2">Option 2</option>
//    </select>

    @BeforeMethod // 3
    public void setup(){ // 2
        driver = BrowserFactory.getDriver("chrome"); // 4
        driver.get("http://practice.cybertekschool.com/"); // 5
        driver.findElement(By.linkText("Dropdown")).click(); // 6
    }

    @Test(description = "Select option 2 from the dropdown") // 11
    public void test1(){ // 10
        // To work with select dropdowns, we need to use Select class in Selenium
        // Step 1: Find dropdown and create a webelement.
        WebElement dropdown = driver.findElement(By.id("dropdown")); // 12
        // Step 2: Create a Select object. Select class requires webelement object
        //  as a parameter
        Select select = new Select(dropdown); // 13
        // Step 3: Select any option by visible text:
        select.selectByVisibleText("Option 2"); // 14
        // Also, you can select by value or index.
       // <option value="1">Option 1</option> -> value is 1, Option 1 is
        //  a visible text in between >Text<

        BrowserUtils.wait(2); // 15

        // How to verify that option 2 is selected?
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 2"); // 16
        // select.getFirstSelectedOption() -> to get selected option
        // -> test passed
    }


    @Test(description = "Print list of states") // 18
    public void test2(){ // 17
        WebElement state = driver.findElement(By.id("state")); // 19
        Select select = new Select(state); // 20

        // to select all states:
        List<WebElement> states = select.getOptions(); // 21
        // select.getOptions() -> returns available options to select

        // How to print every option as a text one by one?
        for (WebElement option : states){ // 22
            System.out.println(option.getText()); // 23
            /*
            Select a State
            Alabama
            Alaska
            Arizona
            Arkansas
            California
            Colorado
            Connecticut
            Delaware
            District Of Columbia
            Florida
            Georgia
            Hawaii
            Idaho
            Illinois
            Indiana
            Iowa
            Kansas
            Kentucky
            Louisiana
            Maine
            Maryland
            Massachusetts
            Michigan
            Minnesota
            Mississippi
            Missouri
            Montana
            Nebraska
            Nevada
            New Hampshire
            New Jersey
            New Mexico
            New York
            North Carolina
            North Dakota
            Ohio
            Oklahoma
            Oregon
            Pennsylvania
            Rhode Island
            South Carolina
            South Dakota
            Tennessee
            Texas
            Utah
            Vermont
            Virginia
            Washington
            West Virginia
            Wisconsin
            Wyoming
             */
        }
    }


    @Test(description = "Select your state and verify that state is selected") // 25
    public void test3(){ // 24
        WebElement state = driver.findElement(By.id("state")); // 26
        Select select = new Select(state); // 27
        // <option value="MD">Maryland</option>
        // We can use text, value, or index for selection
        select.selectByValue("MD"); // 28
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Maryland"); // 29
        // -> test passed

    }


    @AfterMethod // 8
    public void teardown(){ // 7
        driver.quit(); // 9
    }
}
