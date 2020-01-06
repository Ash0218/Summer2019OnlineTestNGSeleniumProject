package pages; // 120619

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BrowserUtils;
import utils.Driver;

public class CreateCarPage extends BasePage { // 1
    // extended BasePage


// This method (#2-8) stands for selecting tags.
    // Provide tag name to select the checkbox. If checkbox is already
    //  selected, it will not do anything.
    public void selectTags(String tagName){ // 2
        String locator = "//label[text()='"+tagName+"']/preceding-sibling::input[@type='checkbox']"; // 3
        // tagName -> it can locate all different tag names such as Convertible,
        //  Senior, or Junior, etc in the Website, Vytrack.com -> Vehicles -> Create Car

        WebElement checkBox = Driver.get().findElement(By.xpath(locator)); // 4
        BrowserUtils.waitForVisibility(checkBox, 15); // 5
        BrowserUtils.waitForClickablility(checkBox, 15); // 6
        if (!checkBox.isSelected()){ // 7
            checkBox.click(); // 8
        }
    }

}
