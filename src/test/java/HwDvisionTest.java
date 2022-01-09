import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HwDvisionTest extends BaseTest{
    Calculator calculator = new Calculator("Division");

    @Test(groups = {"smoke", "regression",})
    public void divisionPositiveDigitsTest() {
       double ss = calculator.division(5.4, 5.4);
        Assert.assertEquals(ss,1,"Деление работает некорректно");
    }
    @Test (groups = "smoke", priority = 1)
    public void divisionNegativeDigitsTest() {
        int  ss = (int) calculator.division(-5,-4);
        Assert.assertEquals(ss,1,"Деление работает некорректно");
    }
    @Test (priority = 2,invocationCount = 6, threadPoolSize = 2)
    public void divisionOfZerosTest() {
        double ss = calculator.division(0,0);
        Assert.assertEquals(false,equals("nan"));
    }
    @Test (description = "division Negative and Positive")
    public void divisionNegativeAndPositiveDigitsTest() {
        int ss = (int) calculator.division(10,-10);
        Assert.assertEquals(ss,-1,"Деление работает некорректно");
    }
    @Test (dataProvider = "dataForDivision", dataProviderClass = StaticProvider.class, groups = "regression")
    public void sumTwo_DigitsThree_DigitsTest(double a,double b, double expectedResult) {
        double ss = calculator.division(a,b);
        Assert.assertEquals(ss,expectedResult,"Деление работает некорректно");
    }

    @Test (retryAnalyzer = Retry.class)
    public void test() {
        double ss = calculator.division(5,4);
        Assert.assertEquals(ss,4,"Деление некорректное");
    }


}
