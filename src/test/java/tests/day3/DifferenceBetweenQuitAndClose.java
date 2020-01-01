package tests.day3; // 102119 - one

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class DifferenceBetweenQuitAndClose {

    public static void main(String[] args) throws InterruptedException { // 1
        WebDriverManager.chromedriver().setup(); // 2
        ChromeDriver driver = new ChromeDriver(); // 3
        driver.get("https://practice-cybertekschool.herokuapp.com/open_new_tab"); // 4

        // To wait for 4 seconds (pause program execution):
        Thread.sleep(4000); // 5
        // But #5 has an error -> needs an exception.
        // #1 was added with "throws InterruptedException" and the error is gone.

        // Let's close browser:
   //     driver.close(); // 6
        // only one tab is closed

        driver.quit(); // 7
        // It closed the browser (all tabs)
    }
}
