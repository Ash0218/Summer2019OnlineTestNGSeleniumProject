package tests.day13; // 112519  one

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.List;

public class WebTablesPractice {
    private WebDriver driver; // 1

    // Explicit wait
    private WebDriverWait wait; // 13

    // table
    //  thead - table header (columns names)
    //  tbody - table body (content)
    //  tr - table row
    //  td - table data
    //  th - table header data
    @BeforeMethod // 2
    public void setup(){ // 3
        driver = BrowserFactory.getDriver("chrome"); // 4
        driver.get("http://practice.cybertekschool.com/tables"); // 5

        // Explicit wait
        wait = new WebDriverWait(driver, 15); // 14

        // wait for presence of table 1
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("table1"))); // 15
        // it should be before #11
        // If you are getting NoSuchElementException -> use this wait for
        //  any element, not only web table.
        // Since #15 is common step for all tests, so it is in the @BeforeMethod.
    }


    @Test(description = "Print table 1 data") // 9
    public void test1(){ // 10

        // <table> stands for web table in HTML
        // table1 is id of first table
        // once we find this table as web element, we can print all text from there
        WebElement table = driver.findElement(By.id("table1")); // 11
        System.out.println(table.getText()); // 12
    }


    @Test(description = "Verity that number of columns in the first table is equals to 6 ") // 17
    public void test2(){ // 16

        int actualColumnNumber = driver.findElements(By.xpath("//table[@id='table1']//tr//th")).size(); // 18
        // size = amount of elements

        int expectedColumnNumber = 6; // 19
        Assert.assertEquals(actualColumnNumber, expectedColumnNumber); // 20
        // -> Test passed
    }

    // to exclude first row (thead rows) = //table[@id='table1']//tbody//tr -> 5-1 = 4
    // "//" means any child. In this case, any tr element of the table.
    @Test(description = "Verify that number of rows in the first table is equals to 5") // 21
    public void test3(){ // 22
        int expectedRowCount = 5; // 23
        int actualRowCount = driver.findElements(By.xpath("//table[@id='table1']//tr")).size(); // 24
        Assert.assertEquals(actualRowCount, expectedRowCount); // 25
        // -> Test passed
    }

    /*
    Use findElements() to find all values from 2nd row.
    Then iterate through the collection of elements with for each loop.
    Print text of every element from new line.
     */
    @Test(description = "Print all values from the 2nd row (excluding table header") // 27
    public void test4(){ // 26
        List<WebElement> row = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[2]//td")); // 28
        for (WebElement cell : row){ // 29
            System.out.println(cell.getText()); // 30
            /*
            Bach
            Frank
            fbach@yahoo.com
            $51.00
            http://www.frank.com
            edit delete

            Test passed
             */
        }
    }

    @Test(description = "Print all values from the nth row (excluding table header") // 32
    public void test5() { // 31

        // If index = 1 -> first row. If index = 2 -> second row.
        // If we don't specify td index, it will take all td elements.
        // cssSelector alternative: table[id='table1'] tbody tr:nth-of-type(2) td
        //  In css, we use space " ". In xpath, // to get to any child.
        //  Or, in css, we use ">". In xpath, / to get to direct child.
        // If index exceeds table size, you will not get any errors, list will
        //  be just empty. findElements() doesn't give NoSuchElementException in
        //  any case.
        int index = 1; // 33
        List<WebElement> row = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[" + index + "]//td")); // 34
        for (WebElement cell : row) { // 35
            System.out.println(cell.getText()); // 36
            /*
            Smith
            John
            jsmith@gmail.com
            $50.00
            http://www.jsmith.com
            edit delete
             */
        }
    }


    @Test(description = "Verify that email in the 3rd row is equal to jdoe@hotmail.com") // 38
    public void test6(){ // 37
        int row = 3; // 40
        // represents row number

        int column = 3; // 41
        // represents column number

        WebElement cell = driver.findElement(By.xpath("//table[@id='table1']//tbody//tr[" +row+ "]//td["+column +"]")); // 39
        // combination of tr and td index will give us specific cell value.

        String expectedEmail = "jdoe@hotmail.com"; // 42
        String actualEmail = cell.getText(); // 43
        Assert.assertEquals(actualEmail, expectedEmail); // 44
        // -> Test passed
    }

    /*
    Get all values from email column and verify that every value contains "@"
    If no - test fails.
     */
    @Test(description = "Verify that every email contains @") // 46
    public void test7(){ // 45

        // get all emails
        // td[3] - third column
        // We are skipping tr b.c we need data from all rows.
        List<WebElement> emails = driver.findElements(By.xpath("//table[@id='table1']//tbody//td[3]")); // 47

        // loop through collection of emails
        for (WebElement email : emails){ // 48
            System.out.println(email.getText()); // 50
            /*
            jsmith@gmail.com
            fbach@yahoo.com
            jdoe@hotmail.com
            tconway@earthlink.net
             */
            Assert.assertTrue(email.getText().contains("@")); // 49
        }
    }

    /*
    Step1: Click on last name column name
    Step2: Get all values from "last name" column
    Step3: Verify that column is sorted in alphabetic order
     */
    @Test(description = "Verify that after click on las name, values will be sorted in alphabetic order") // 52
    public void test8() { // 51

        WebElement lastNameElement = driver.findElement(By.xpath("//table[@id='table1']//*[text()='Last Name']")); // 57
        lastNameElement.click(); // 58
        List<WebElement> lastNames = driver.findElements(By.xpath("//table[@id='table1']//tbody//td[1]")); // 59
        //   for (WebElement lastName : lastNames){ // 60
        //     System.out.println(lastName.getText()); // 61
            /*
            Bach
            Conway
            Doe
            Smith
             */
    // }

         for (int index=0; index < lastNames.size() - 1; index++){ // 62
             // -1: to avoid IndexOutOfBoundsException

             String lastName = lastNames.get(index).getText(); // 63
             String followingLastName = lastNames.get(index + 1).getText(); // 64
             System.out.println("############### Iteration :: "+ index); // 67
             System.out.println("Current Last Name: " + lastName); // 66
             System.out.println("Following Last Name" + followingLastName); // 68
             System.out.println("#######################################"); // 69
             Assert.assertTrue(lastName.compareTo(followingLastName) < 0); // 65
            // -> Test passed

             /*
             ############### Iteration :: 0
            Current Last Name: Bach
            Following Last NameConway
            #######################################
            ############### Iteration :: 1
            Current Last Name: Conway
            Following Last NameDoe
            #######################################
            ############### Iteration :: 2
            Current Last Name: Doe
            Following Last NameSmith
            #######################################
              */
        }
    }


    @AfterMethod // 6
    public void teardown(){ // 7
        driver.quit(); // 8
    }

   /* public static void main(String[] args) { // 53
        String word = "a"; // 53
        // 97 in ascii table

        String word2 = "d"; // 54
        // 100 in ascii table

        System.out.println(word.compareTo(word2)); // 55
        // -> -3 (97 - 100 = -3)
        // If result < 0 -> sequence of words is correct
        // If result = 0 -> words are equal
        // If result > 0 -> sequence of words is opposite to alphabetic order
        // It checks character by character. If 1st character is the
        //  same, it compares 2nd one.

        System.out.println(word.compareTo(word2)<0); // 56
        // true

    }

    */
}
