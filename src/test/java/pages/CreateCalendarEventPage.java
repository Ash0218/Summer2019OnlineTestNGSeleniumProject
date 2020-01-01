package pages; // 120319

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateCalendarEventPage extends BasePage{ // 1
    // added extends BasePage

    @FindBy(css = "[class='select2-chosen']") // 3
    public WebElement owner; // 2
}
