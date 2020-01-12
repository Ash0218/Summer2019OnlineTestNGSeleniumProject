package tests.day22_review; // 121319

import org.testng.annotations.Test;
import utils.ExcelUtil;

import java.util.HashMap;
import java.util.Map;

public class ReadTestDataFromExcelFile {

    @Test // 2
    public void test1(){ // 1
        ExcelUtil cars = new ExcelUtil("cars.xlsx", "cars"); // 3
        System.out.println(cars.getDataList()); // 4
        String color = cars.getDataList().get(0).get("Color"); // 5
        // get(0) means get data from first row.
        // get("Color") means get value of Color column, from first row

        String driverName = cars.getDataList().get(0).get("Driver"); // 7
        System.out.println(color); // 6
        // red
        System.out.println(driverName); // 8
        // Michael Schumacher

        Map<String, String> row = new HashMap<>(); // 9
        // instead of index, we use key name. In list, we use index, in map -
        //  key name. Every value is referenced by key. Key must be unique.
        // We have to specify data type of key and value. Tey can be different.
        // Same thing like with list: List<String>
        // Map -> key = value, List -> index = value
        row.put("License Plate", "777"); // 10
        // Key = License Plate, Value = 777
        row.put("Driver", "SDET Driver"); // 11
        System.out.println(row.get("Driver")); // 12
        // SDET Driver

        Map<Integer, String> values = new HashMap<>(); // 13
        values.put(1, "apple"); // 14

        // key = Country name, value = Country code
        Map<String, String> countryCodes = new HashMap<>(); // 15
        countryCodes.put("USA", "+1"); // 16
        countryCodes.put("Australia", "+036"); // 17
        countryCodes.put("China", "+85"); // 18
        countryCodes.put("Kazakhstan", "+7"); // 19
        countryCodes.put("Ukraine", "+380"); // 19
        countryCodes.put("South Korea", "+82"); // 19
        countryCodes.put("Turkey", "+90"); // 19
        countryCodes.put("Uzbekistan", "+998"); // 19
        countryCodes.put("Azerbaijan", "+993"); // 19

        System.out.println(countryCodes.get("USA")); // 20
        // +1.
        // If the key is wrong, you will get null.


    }
}
