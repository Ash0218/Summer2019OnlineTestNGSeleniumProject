package tests.day7; // 111219   one

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

import java.util.List;

public class WarmUp {

    public static void main(String[] args) { // 1
        WebDriver driver = BrowserFactory.getDriver("chrome"); // 2
        driver.get("https://cybertekschool.com/"); // 3
        // How to find all links?
        // Every link has a tag name, <a>
        List<WebElement> links = driver.findElements(By.xpath("//a")); // 4
       // we don't know how many elements (links), so we used
        // findElements, not findElement.

        System.out.println("Number of links: "+links.size()); // 5
        // -> Number of links: 64

        // findElement vs. findElements:
        //  in case of finding element, if there is no element found, you will
        //  get NoSuchElementException.
        //  findElement: only 1 webElement
        //  findElements: 0 or more elements
        // If the list is empty, that means element is not there. In this
        //  way, we can ensure that element doesn't present.
        // In the cybertekschool.com -> //a[.='Home'] or //a[text()='Home'] finds link with text
        //  named Home. (type in the inspect, then it shows elements of Home)


        // What if I want to print text of all links one by one?
        //  loop through the collection of links
        for (WebElement webElement: links){ // 6
            // If text is there (the element is not empty),
            if(!webElement.getText().isEmpty()){ // 8
                // Print text of every link
                System.out.println(webElement.getText()); // 7
            }


        }


        driver.quit(); // 6
    }
}
