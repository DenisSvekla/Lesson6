package data;

import org.testng.annotations.DataProvider;

public class StaticProvider {

    @DataProvider (name = "dataForSum")
    public static Object [][] dataForSumFunction() {
        return new Object[][] {
                {2, 0, 2},
                {3, 5, 8},
                {4, -4, 0},

        };
    }
    @DataProvider (name = "dataForDivision")
    public static Object [][] dataForDivisionFunction() {
        return new Object[][] {
                {2, 1, 2},
                {3, 3, 1},
                {100, -4, -25},
                {4.1, 1, 4.1},

        };
    }
}
