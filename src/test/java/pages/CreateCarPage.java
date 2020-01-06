package pages; // 120619

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BrowserUtils;
import utils.Driver;

public class CreateCarPage extends BasePage { // 1
    // extended BasePage

    @FindBy(css = "[id^='custom_entity_type_LicensePlate']") // 10
    public WebElement licensePlateElement; // 9

    @FindBy(name = "custom_entity_type[Driver]") // 13
    // clicked the blank box of Driver to find 'custom_entity_type[Driver]'
    public WebElement driverElement; // 12

    @FindBy(name = "custom_entity_type[Location]") // 15
    public WebElement locationElement; // 14

    @FindBy(xpath = "//div[@class='btn-group pull-right open']/button[contains(text(),'Save and Close')]") // 17
    public WebElement saveAndCloseButtonElement; // 16

    @FindBy(css = "div[id*='FuelType']") // 19
    public WebElement fuelTypeElement; // 18


// This method (#2-8) stands for selecting tags.
    // Provide tag name to select the checkbox. If checkbox is already
    //  selected, it will not do anything.
    public WebElement selectTags(String tagName){ // 2
        // Instead of WebElement, you can use 'void'. But, for this, you have to
        //  delete #11.

        String locator = "//label[text()='"+tagName+"']/preceding-sibling::input[@type='checkbox']"; // 3
        // tagName -> it can locate all different tag names such as Convertible,
        //  Senior, or Junior, etc in the Website, Vytrack.com -> Vehicles -> Create Car.
        //  tagName represents name of tag that has to be selected.
        // locator for checkbox is based on label name. Label and checkbox
        //  are siblings.
        // Or you can use this: CreateCarPage createCarPage = new CreateCarPage();
        //  createCarPage.selectTags("Senior"); -> Senior tag will be selected.

        WebElement checkBox = Driver.get().findElement(By.xpath(locator)); // 4
        BrowserUtils.waitForVisibility(checkBox, 15); // 5
        BrowserUtils.waitForClickablility(checkBox, 15); // 6
        if (!checkBox.isSelected()){ // 7
            checkBox.click(); // 8
        }
        return checkBox; // 11
        // return WebElement of checkbox that was selected
    }

}
