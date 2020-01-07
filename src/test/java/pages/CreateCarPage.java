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

    @FindBy(css = "[class='btn btn-success action-button']") // 17
    public WebElement saveAndCloseButtonElement; // 16

    @FindBy(css = "div[id*='FuelType']") // 19
    public WebElement fuelTypeElement; // 18

    // if #29 doesn't work, use this:
    //  [id^='uniform-custom_entity_type_Logo_file'] > span[class='action']
    @FindBy(name = "custom_entity_type[Logo][file]") // 29
    public WebElement logoElement; // 28


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


    public void selectFuelType(String fuelType){ // 20
     //   String locator = "//div[@class='select2-result-label' and text()='Diesel']"; // 21
        // 'Diesel' -> represents values like Diesel or Electric, so change to fuelType to
        //  use for other values.

        String locator = "//div[@class='select2-result-label' and text()='" + fuelType + "']"; // 22
        // it selects fuel type by visible text. fuelType -> Diesel,
        //  Electric, Hybrid, or Gasoline.
        // If you use this (like the above): CreateCarPage createCarPage = new CreateCarPage();
        //  you can put like this: createCarPage.selectFuelType("Diesel");

        BrowserUtils.waitForClickablility(fuelTypeElement, 15); // 23
        fuelTypeElement.click(); // 24
        WebElement fuelTypeSelectionElement = Driver.get().findElement(By.xpath(locator)); // 25
        BrowserUtils.waitForClickablility(fuelTypeSelectionElement, 15); // 26
        fuelTypeSelectionElement.click(); // 27
    }

    // This method (#30) will upload a file from your computer that you want ->
    //  pathToTheFile (file that you want to upload)
    public void uploadLogo(String pathToTheFile){ // 30
        BrowserUtils.waitForVisibility(logoElement, 15); // 32
        logoElement.sendKeys(pathToTheFile); // 31
    }

}
