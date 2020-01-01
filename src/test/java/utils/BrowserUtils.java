package utils; // two

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {

    // It will be used to pause our execution. Just provide number of seconds
    //  as a parameter.
    public static void wait(int seconds){ // 1
        try { // 3
            Thread.sleep(1000*seconds); // 2
        } catch (InterruptedException e) { // 3
            // Added try & catch by using option + enter: #3,4 automatically created
            e.printStackTrace();  // 4
        }
    }
    
    /*
    Wait for element not to be stale.
     */
    public static void waitForStaleElement(WebElement element){ // 5
        int y = 0; // 6
        while (y <= 15){ // 7
            try {  // 8
                element.isDisplayed(); // 9
                break; // 10
            } catch (StaleElementReferenceException st){ // 11
                y++; // 12
                try { // 13
                    Thread.sleep(200); // 14
                } catch (InterruptedException e) { // 15
                    e.printStackTrace(); // 16
                }
            }
            break; // 17
        }
    }
    /*
    Waits for the provided element to be visible on the page.
     */
    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec){ // 18
        WebDriverWait wait = new WebDriverWait(Driver.get(), timeToWaitInSec); // 19
        return wait.until(ExpectedConditions.visibilityOf(element)); // 20
    }

    public static void ClickWithJS(WebElement element) { // 21
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element); // 22
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].click();", element); // 23
    }

    /*
    Waits for provided element to be clickable
     */
    public static WebElement waitForClickablility(WebElement element, int timeout) { // 24
        WebDriverWait wait = new WebDriverWait(Driver.get(), timeout);  // 25
        return wait.until(ExpectedConditions.elementToBeClickable(element)); // 26
    }
}
