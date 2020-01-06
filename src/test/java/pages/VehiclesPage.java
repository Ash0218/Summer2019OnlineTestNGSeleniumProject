package pages; // 120619

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BrowserUtils;

public class VehiclesPage extends BasePage { // 1
    // extended BasePage

    @FindBy(css = "[title='Create Car']") // 3
    // [title='Create Car'] -> from the Vytrack website in Vehicles.
    // @FindBy is coming from PageFactory which is from BasePage. So,
    //  BasePage is the super page.

    public WebElement createACarElement; // 2

    public void clickToCreateACar(){ // 4
        BrowserUtils.waitForVisibility(createACarElement, 15); // 6
        BrowserUtils.waitForClickablility(createACarElement, 15); // 7
        // For #6,7: use this method to click on "Create a Car" button.
        // Method already contains waits to handle synchronization issues.
        createACarElement.click(); // 5
    }
}
