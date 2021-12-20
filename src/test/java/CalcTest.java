import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcTest extends BaseTest {
    Calculator calculator = new Calculator("CalcTest");

    @Test (invocationCount = 3, invocationTimeOut = 1000)
    public void invocationTest () throws InterruptedException {
        Thread.sleep(700);
        Assert.assertEquals(calculator.sum(2,3),5);

    }
}
