package tests.day7; // four

import org.testng.Assert;
import org.testng.annotations.*;

public class AnnotationsTest {

    @BeforeClass // 18
    // it can run only once before @BeforeMethod, and before all tests (@Test).
    public void beforeClass(){ // 17
        System.out.println("Before class!"); // 19
         /*
        Before class!
        Before method!
        Test 1!
        Before method!
        Test 2!
        Before method!
        Test 3!
         */
    }

    // it can run only once after @AfterMethod, and after all tests (@Test).
    @AfterClass // 21
    public void afterClass(){ // 20
        System.out.println("After class!"); // 22
         /*
        Before class!
        Before method!
        Test 1!
        Before method!
        Test 2!
        Before method!
        Test 3!
        After class!
         */
    }


    // Runs automatically before every test.
    @BeforeMethod // 12
    public void setup(){ // 11
        // some code that will be running before every test, like: test1, test2,
        //  test3,... -> we can use method with @BeforeMethod annotation.
        System.out.println("Before method!"); // 13
        /*
        Before method!
        Test 1!
        Before method!
        Test 2!
        Before method!
        Test 3!
         */
    }

    // Runs automatically after every test.
    @AfterMethod // 15
    public void teardown(){ // 14
        System.out.println("After Method!"); // 16
        /*
        Before method!
        Test 1!
        After Method!
        Before method!
        Test 2!
        After Method!
        Before method!
        Test 3!
        After Method!

        @BeforeMethod and @AfterMethod cannot work alone without @Test
         */
    }

    @Test // 2
    public void test1(){ // 1
        System.out.println("Test 1!"); // 3
        Assert.assertTrue(5 == 5); // 10
    }

    @Test // 4
    public void test2(){ // 5
        System.out.println("Test 2!"); // 6
    }

    @Test // 7
    public void test3(){ // 8
        System.out.println("Test 3!"); // 9
    }
}
