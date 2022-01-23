import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HwMultiplicationTest extends BaseTest {
    Calculator cal = new Calculator("multiplication");

    @Test(groups = {"smoke", "regression",})
    public void multiplicationPositiveDigitsTest() {
        int ss = (int) cal.multiplication(5, 4);
        Assert.assertEquals(ss, 20, "умножение с валидными положительными числами не работает");
    }

    @Test(groups = "smoke", priority = 1)
    public void multiplicationNegativeDigitsTest() {
        int ss = (int) cal.multiplication(-50, -43);
        Assert.assertEquals(ss, 2150, "Умножение с валидными отрицательными числами " +
                "работает некорректно");
    }

    @Test(priority = 2, invocationCount = 6, threadPoolSize = 2)
    public void multiplicationOfZerosTest() {
        int ss = (int) cal.multiplication(0, 0);
        Assert.assertEquals(ss, 0, "умножение на ноль работает некорректно");
    }

    @Test(description = "multiplication Negative and Positive")
    public void multiplicationNegativeAndPositiveDigitsTest() {
        int ss = (int) cal.multiplication(123, -10);
        Assert.assertEquals(ss, -1230, "умножение с валидными отрицательными" +
                "и положительными цифрами работает некорректно");
    }

    @Test(dataProvider = "dataForMult", dataProviderClass = StaticProvider.class, groups = {"smoke", "regression",})
    public void multiplicationTwo_DigitsThree_DigitsTest(double a, double b, double expectedResult) {
        double ss = cal.multiplication(a, b);
        Assert.assertEquals(ss, expectedResult, "Умножение при двух/ трех числах работает некорректно");
    }

    @Test(retryAnalyzer = Retry.class)
    public void negativeTest() {
        int ss = (int) cal.multiplication(53, 42);
        Assert.assertEquals(ss, 4, "Умножение некорректное");
    }
}
