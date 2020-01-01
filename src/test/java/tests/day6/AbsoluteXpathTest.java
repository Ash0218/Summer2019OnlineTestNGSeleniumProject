package tests.day6; // 110819       one

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class AbsoluteXpathTest {

    public static void main(String[] args) { // 1
        WebDriver driver = BrowserFactory.getDriver("chrome"); // 2

        // Ex1:
        // Go to the website, https://qa2.vytrack.com/user/login
        // right click -> inspect -> command + F -> type /html/body/div[1]/div
        //  /div/div/div[1]/form/fieldset/div[1]/div

        // Ex2: Vytrack warning message
        // Go to login1.nextbasecrm.com
        // right click -> inspect -> command + F
        // type /html/body/table/tbody/tr[2]/td/div/div/div[2]


        driver.get("https://login1.nextbasecrm.com/auth/?login=yes"); // 3
        // Click on login without entering username and password to invoke
        //  warning message
        driver.findElement(By.className("login-btn")).click(); // 4
        BrowserUtils.wait(2); // 5
        WebElement warningmessage = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/div/div/div[2]")); // 5
        // command + z = step back, command + z + shift = step forward
        System.out.println(warningmessage.getText()); // 7
        // to read the text of warning message -> use only Chrome browser

        driver.quit(); // 8
        // end the test execution








    }
}
