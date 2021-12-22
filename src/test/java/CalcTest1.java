import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcTest1 extends BaseTest {
    Calculator calc = new Calculator("CalcTest1");

    @Test (description = "Test of Summ in My Calculator", groups = "smoke")
    public void testSum () {
        System.out.println("CalcTest -> testSum");
    }
    @Test
    public void testSum1 () {
        System.out.println("CalcTest1 -> testSum1");
    }

    @Test (dataProvider = "dataForSum", dataProviderClass = StaticProvider.class)
    public void dataProviderTest(int a, int b, int expectedResult) {
        Assert.assertEquals(calc.sum(a,b), expectedResult);

    }
}
