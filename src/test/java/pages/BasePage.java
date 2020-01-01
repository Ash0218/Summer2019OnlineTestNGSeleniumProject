package pages; // 120219
// everything that is in common among pagescan go here.
// EX: top menu elements don't belong to specific page but
//  top menu appears on every single page, so we can keep them here.

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserUtils;
import utils.Driver;

public abstract class BasePage { // 1
// added "abstract"

    @FindBy(css = "div[class='loader-mask shown']") // 8
    // div[class='loader-mask shown'] -> from CalendarEventsTests of vytrack package.
    // (#28)
    public WebElement loaderMask; // 7

    @FindBy(css = "h1[class='oro-subtitle']") // 32
    public WebElement pageSubTitle; // 31

    @FindBy(css = "#user-menu > a") // 34
    public WebElement userName; // 33

    @FindBy(linkText = "Logout") // 36
    public WebElement logOutLink; // 35

    @FindBy(linkText = "My User") // 38
    public WebElement myUser; // 37


    public BasePage() { // 2
        PageFactory.initElements(Driver.get(), this); // 3
        // this method requires to provide webdriver object for @FindBy
        //  and page class. this -> current page class.

    }


    public boolean waitUntilLoaderMaskDisappear() { // 19
        // you can use void instead of boolean
        WebDriverWait wait = new WebDriverWait(Driver.get(), 5); // 20

        try { // 22
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[class*='loader-mask']"))); // 21
            // waits until loader mask (loading bar or spinning wheel) disappear
            // While this loading screen present, html code is not complete.
            // Some elements can be missing. Also, you won't be able to
            //  interact with any elements.
            // All actions will be intercepted

            return true;  // 24
            // return true if loader mask is gone. false if something went wrong.

        } catch (NoSuchElementException e) { // 23
            System.out.println("Loader mask not found"); // 27
            e.printStackTrace(); // 27
         //   System.out.println(e.getMessage()); // 26
            return true; // 30
            // no loader mask, all good, return true

        } catch (WebDriverException e){ // 28
            System.out.println(e.getMessage()); // 29
        }
        return false; // 25

    }

    // this method stands for navigation in vytrack app.
    // Provide tab name, ex: Fleet as a String and module name, ex: Vehicles
    //  as a String as well. Then based on these values, locators will be
    //  created.
    public void navigateTo(String moduleName, String subModuleName) { // 4
        String moduleLocator = "//*[normalize-space()='" + moduleName + "' and @class='title title-level-1']"; // 5
        // moduleName -> it can be Dashboard, Fleet, Customers, etc in the website,
        //  https://qa1.vytrack.com/
        // //*[normalize-space()='Fleet' and @class='title title-level-1']
        //  -> deleted "Fleet" and put "moduleName
        // normalize-space() -> same as .trim() in java. It removes spaces
        //  between codes.

        String subModuleLocator = "//*[normalize-space()='" + subModuleName + "' and @class='title title-level-2']"; // 6
        // //*[normalize-space()='Vehicles' and @class='title title-level-2']
        //  -> deleted "Vehicles" and put "subModuleName"

        WebDriverWait wait = new WebDriverWait(Driver.get(), 10); // 9
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(moduleLocator))); // 10

        WebElement module = Driver.get().findElement(By.xpath(moduleLocator)); // 11

        wait.until(ExpectedConditions.visibilityOf(module)); // 12
        wait.until(ExpectedConditions.elementToBeClickable(module)); // 13

        waitUntilLoaderMaskDisappear(); // 54
        // added this to avoid error

        module.click(); // 14
        // once we click the module, submodule should be visible.

        WebElement subModule = Driver.get().findElement(By.xpath(subModuleLocator)); // 15
        wait.until(ExpectedConditions.visibilityOf(subModule)); // 16
        subModule.click(); // 17, 18


    }


    public String getPageSubTitle(){ // 38
        waitUntilLoaderMaskDisappear(); // 39
        BrowserUtils.waitForStaleElement(pageSubTitle); // 40
        return pageSubTitle.getText(); // 41
    }

    public String getUserName(){ // 42
        waitUntilLoaderMaskDisappear(); // 43
        BrowserUtils.waitForVisibility(userName, 5); // 44
        return userName.getText(); // 45
    }

    public void logOut(){ // 46
        BrowserUtils.wait(2); // 47
        BrowserUtils.ClickWithJS(userName); // 48
        BrowserUtils.ClickWithJS(logOutLink); // 49
    }

    public void goToMyUser(){ // 50
        waitUntilLoaderMaskDisappear(); // 51
        BrowserUtils.waitForClickablility(userName, 5).click(); // 52
        BrowserUtils.waitForClickablility(myUser, 5).click(); // 53
    }





}
