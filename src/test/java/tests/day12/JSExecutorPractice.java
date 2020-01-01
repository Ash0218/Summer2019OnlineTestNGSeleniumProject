package tests.day12; // four

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class JSExecutorPractice {
    private WebDriver driver; // 2


    @BeforeMethod // 3
    public void setup(){ // 1
        driver = BrowserFactory.getDriver("chrome"); // 4
    }

    @Test(description = "Scrolling with JavaScriptExecutor") // 8
    public void test1(){ // 9
        driver.get("http://practice.cybertekschool.com/infinite_scroll"); // 10
        JavascriptExecutor js = (JavascriptExecutor) driver; // 11

        for (int i =0; i< 10; i++) { // 14

            // move 500px down. 0, 500 -> (x,y) in graph.
            js.executeScript("window.scrollBy(0, 500);"); // 12
            // scroll the web-page infinitely

            BrowserUtils.wait(1); // 15
            // -> Test passed
        }

                BrowserUtils.wait(3); // 13

            }


      @Test(description = "Scrolling with JSExecutor to sepcific element") // 16
      public void test2(){ // 17
        driver.get("http://practice.cybertekschool.com/large"); // 18
          WebElement link = driver.findElement(By.linkText("Cybertek School")); // 19
          BrowserUtils.wait(2); // 20
          JavascriptExecutor js = (JavascriptExecutor) driver; // 21

          // This script must scroll until link element is not visible. Once
          //  link element is visible, it will stop scrolling.
          js.executeScript("arguments[0].scrollIntoView(true)", link); // 22
          // arguments[0] -> first webElement after comma (link)
          // arguments -> array of WebElement after comma. ( (true)", link, link, link..)
          // arguments[0] = link web element, it can be any web element.

          // js code from the browser:
          //  var footer = document.getElementById('page-footer');
          //  footer.scrollIntoView(true)
          //  -> type these in the inspect -> console in the website -> same result

          BrowserUtils.wait(2); // 23
          // -> test passed
      }


      //  var btn1 = document.getElementsByTagName('a')[1];
      //  btn1.click()
      @Test(description = "Clcik with JS executor") // 24
      public void test3(){ // 25
        driver.get("http://practice.cybertekschool.com/dynamic_loading"); // 26
        WebElement link1 = driver.findElement(By.partialLinkText("Example 1")); // 27
        // find Example 1 in the website

          JavascriptExecutor js = (JavascriptExecutor) driver; // 28
          // Create an object of JavaScriptExecutor

          js.executeScript("arguments[0].click()", link1); // 29
          // Click web element, link1. arguments[0] = link1
          // Find link1 and click it
          // arguments[0] means the first web element after comma -> link1
          // [0] -> first web element, link1
          // Whenever regular selenium methods are not working, I use js
          //  executor for scrolling.
          // arguments[0].click() is an alternative for link1.click()

          BrowserUtils.wait(2); // 30
          // -> Test passed
    }


    // document.getElementsByName('full_name')[0].setAttribute('value','My name')
    //  -> go to http://practice.cybertekschool.com/sign_up -> Inspect
    //  -> console -> type document.getElementsByName('full_name')[0].setAttribute('value','My name')
    //  -> it types "My name" in the box automatically.



    @Test(description = "Enter text with JS executor") // 31
    public void test4(){ // 32
        driver.get("http://practice.cybertekschool.com/sign_up"); // 33

        WebElement name = driver.findElement(By.name("full_name")); // 34
        WebElement email = driver.findElement(By.name("email")); // 35
        WebElement submitButton = driver.findElement(By.name("wooden_spoon")); // 39

        // to create javascriptexecutor object, we need to case WebDriver object.
        JavascriptExecutor js = (JavascriptExecutor) driver; // 36

        // Enter full name
        // arguments[0].setAttribute('value', 'John Smith') -> same as name.sendKeys(""John Smith");

        BrowserUtils.wait(2); // 41
        js.executeScript("arguments[0].setAttribute('value', 'John Smith')", name); // 37
        BrowserUtils.wait(2); // 41
        js.executeScript("arguments[0].setAttribute('value', 'someemail@email.com')", email); // 38
        BrowserUtils.wait(2); // 41
        js.executeScript("arguments[0].click()", submitButton); // 40
        BrowserUtils.wait(2); // 41
        // -> Test passed
    }

    @AfterMethod // 5
    public void after() { // 6
        driver.quit(); // 7
    }
}
