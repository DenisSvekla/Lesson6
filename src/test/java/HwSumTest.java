import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HwSumTest extends BaseTest {
    Calculator calculator = new Calculator("sum");

    @Test(groups = "smoke")
    public void sumPositiveDigitsTest() {
        int ss = calculator.sum(5, 4);
        Assert.assertEquals(ss, 9, "Сложение двух валидных чисел работает некорректно");
    }

    @Test(groups = "smoke", priority = 1)
    public void sumNegativeDigitsTest() {
        int ss = calculator.sum(-5, -4);
        Assert.assertEquals(ss, -9, "Сложение двух отрицательных чисел работает некорректно");
    }

    @Test(priority = 2, invocationCount = 6, threadPoolSize = 2)
    public void sumOfZerosTest() {
        int ss = calculator.sum(0, 0);
        Assert.assertEquals(ss, 0, "Сложение двух нулей работает не работает");
    }

    @Test(description = "sum Negative and Positive")
    public void sumNegativeAndPositiveDigitsTest() {
        int ss = calculator.sum(10, -10);
        Assert.assertEquals(ss, 0, "Сложение положительного и отрицательного числа не" +
                "работает ");
    }

    @Test(dataProvider = "dataForSum", dataProviderClass = StaticProvider.class, groups = "regression")
    public void sumTwo_DigitsThree_DigitsTest(int a, int b, int expectedResult) {
        int ss = calculator.sum(a, b);
        Assert.assertEquals(ss, expectedResult, "Сложение двух/трех чисел работает некорректно");
    }

    @Test(retryAnalyzer = Retry.class)
    public void test() {
        int ss = calculator.sum(5, 4);
        Assert.assertEquals(ss, 4, "сложение некорректное");
    }

}
