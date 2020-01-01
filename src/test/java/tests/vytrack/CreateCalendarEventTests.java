package tests.vytrack; // 120319

import org.testng.annotations.Test;
import pages.CalendarEventsPage;
import pages.CreateCalendarEventPage;
import pages.LoginPage;
import tests.TestBase;

public class CreateCalendarEventTests extends TestBase { // 1
    // add extends TestBase

    @Test(description = "Verify owner's name equals to  Stephan Haley (it works on qa1 storemanager85)") // 3
    public void test1(){ // 2
        LoginPage loginPage = new LoginPage(); // 4
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage(); // 5
        CreateCalendarEventPage createCalendarEventPage = new CreateCalendarEventPage(); // 6

        // login as Stephan Haley (storemanager85)
        loginPage.login("storemanager85", "UserUser123"); // 7

        // go to Calendar Events page
        loginPage.navigateTo("Activities", "Calendar Events"); // 8


    }
}
