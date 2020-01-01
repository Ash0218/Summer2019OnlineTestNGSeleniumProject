package tests.day14; // 112719      one

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigurationReader;

public class ConfigReaderTest {

    /*
        #Browser Type (it's a comment)
        browser = chrome
        #key=value, it's like a Map in java
        #color is blue = used before

        #URL of our web application
        url=https://qa1.vytrack.com/
        #color is gray = unused yet

        #Credentials
        user_name=storemanager85
        password=UserUser123
     */

    @Test // 2
    public void test1(){ // 1
        String expectedBrowser = "chrome"; // 3
        // we write keys in "key" as a string. As return, you will get
        //  value, key = value
        // property name = value
        // we don't change property names, we change values
        // the idea is change in the one place, and affect entire framework.
        // let's say every class will read browser type from properties file
        //  and to perform cross-browsing testing, we can easily change value
        //  of browser property.

        String actualBrowser = ConfigurationReader.getProperty("browser"); // 4
        // "browser" = key -> we should get chrome (b.c the value of
        //  "browser" is "chrome".

        Assert.assertEquals(actualBrowser, expectedBrowser); // 5
        // -> Test passed

        System.out.println("URL: " + ConfigurationReader.getProperty("url")); // 6
        // -> https://qa1.vytrack.com/
        // Read value of url property

        System.out.println("Username: " + ConfigurationReader.getProperty("user_name")); // 7
        // -> URL: https://qa1.vytrack.com/
        // -> Username: storemanager85
        // read value of user_name property

        String password = ConfigurationReader.getProperty("password"); // 8
        System.out.println("Password: " + password); // 9
        // read value of password property
        // ->URL: https://qa1.vytrack.com/
        // -> Username: storemanager85
        // -> Password: UserUser123
    }

}
