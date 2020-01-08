package tests.day20_ddt_with_excel; // 121019

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.TestBase;
import utils.ExcelUtil;

import java.util.Map;

public class LoginTestsWithExcel extends TestBase { // 1
    // extended TestBase


    @Test(dataProvider = "credentials", description = "Login with different credentials") // 15
    public void loginTest(String username, String password, String firstName, String lastName, String result) { // 14
    // added 5 String values in #14 b.c the QA2-short in Vytrack testusers.xlsx
        // had 5 variables (columns).

        LoginPage loginPage = new LoginPage(); // 16
        loginPage.login(username, password); // 17
    }

    // @DataProvider is a test data supplier. As many sets of data,
    //  it returns, as many times exactly same test will run.
    @DataProvider(name = "credentials") // 11
    public static Object[][]credentials(){ // 10
        // [][] -> it returns to 2 dimensional array

        ExcelUtil qa2 = new ExcelUtil("Vytrack testusers.xlsx", "QA2-short"); // 12
        return qa2.getDataArray(); // 13
        // data will be returned as a 2D array (from #10).
    }







/*
    public static void main(String[] args) { // 2
        ExcelUtil qa2 = new ExcelUtil("Vytrack testusers.xlsx", "QA2-short"); // 3
        // "Vytrack testusers.xlsx" -> copied path of Vytrack testusers.xlsx file
        //  "QA2-short" -> copied the title inside of Vytrack testusers.xlsx file

        System.out.println("Row count: " + qa2.rowCount()); // 4
        // we have 16 rows in the QA2-short file.

        System.out.println(qa2.getColumnsNames()); // 5
        // -> Row count: 16
        //-> [username, password, firstname, lastname, result]

      //  System.out.println(qa2.getDataList()); // 6
        // -> [{result=n/a, password=UserUser123, firstname=John, username=user1, lastname=Doe}, {result=n/a, password=UserUser123, firstname=Bella, username=user2, lastname=Stamm}, {result=n/a, password=UserUser123, firstname=Marcelino, username=user3, lastname=Hyatt}, {result=n/a, password=UserUser123, firstname=Danielle, username=user4, lastname=Ledner}, {result=n/a, password=UserUser123, firstname=Monte, username=user5, lastname=Marquardt}, {result=n/a, password=UserUser123, firstname=Edd, username=storemanager51, lastname=Turner}, {result=n/a, password=UserUser123, firstname=Eddie, username=storemanager52, lastname=Rodriguez}, {result=n/a, password=UserUser123, firstname=Marietta, username=storemanager53, lastname=Bartell}, {result=n/a, password=UserUser123, firstname=Vena, username=storemanager54, lastname=Schoen}, {result=n/a, password=UserUser123, firstname=Kenton, username=storemanager55, lastname=Ritchie}, {result=n/a, password=UserUser123, firstname=Liza, username=salesmanager101, lastname=Fritsch}, {result=n/a, password=UserUser123, firstname=Pierre, username=salesmanager102, lastname=Prohaska}, {result=n/a, password=UserUser123, firstname=Dillon, username=salesmanager103, lastname=Barrows}, {result=n/a, password=UserUser123, firstname=Mariela, username=salesmanager104, lastname=Koch}, {result=n/a, password=UserUser123, firstname=Lysanne, username=salesmanager105, lastname=Thompson}]

        // Instead of #6, you can use this:
        for (Map<String, String> map: qa2.getDataList()){ // 7
            // map is a data structure; in map, every value is
            //  referenced by key. When we retrieve data from
            //  map, we don't specify index, we specify key name.
            //  Keys must be unique.
            // Keys are represented by column names. Like in
            //  properties file, key = value

         //   System.out.println(map); // 8
            /*
            [username, password, firstname, lastname, result]
            {result=n/a, password=UserUser123, firstname=John, username=user1, lastname=Doe}
            {result=n/a, password=UserUser123, firstname=Bella, username=user2, lastname=Stamm}
            {result=n/a, password=UserUser123, firstname=Marcelino, username=user3, lastname=Hyatt}
            {result=n/a, password=UserUser123, firstname=Danielle, username=user4, lastname=Ledner}
            {result=n/a, password=UserUser123, firstname=Monte, username=user5, lastname=Marquardt}
            {result=n/a, password=UserUser123, firstname=Edd, username=storemanager51, lastname=Turner}
            {result=n/a, password=UserUser123, firstname=Eddie, username=storemanager52, lastname=Rodriguez}
            {result=n/a, password=UserUser123, firstname=Marietta, username=storemanager53, lastname=Bartell}
            {result=n/a, password=UserUser123, firstname=Vena, username=storemanager54, lastname=Schoen}
            {result=n/a, password=UserUser123, firstname=Kenton, username=storemanager55, lastname=Ritchie}
            {result=n/a, password=UserUser123, firstname=Liza, username=salesmanager101, lastname=Fritsch}
            {result=n/a, password=UserUser123, firstname=Pierre, username=salesmanager102, lastname=Prohaska}
            {result=n/a, password=UserUser123, firstname=Dillon, username=salesmanager103, lastname=Barrows}
            {result=n/a, password=UserUser123, firstname=Mariela, username=salesmanager104, lastname=Koch}
            {result=n/a, password=UserUser123, firstname=Lysanne, username=salesmanager105, lastname=Thompson}
             */
/*
            System.out.println(map.get("username")); // 9
            /*
            user1
            user2
            user3
            user4
            user5
            storemanager51
            storemanager52
            storemanager53
            storemanager54
            storemanager55
            salesmanager101
            salesmanager102
            salesmanager103
            salesmanager104
            salesmanager105
             */

/*
        }

    }

 */
}
