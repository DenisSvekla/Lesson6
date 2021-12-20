import org.testng.annotations.Test;

public class CalcTest1 extends BaseTest {

    @Test (description = "Test of Summ in My Calculator", groups = "smoke")
    public void testSum () {
        System.out.println("CalcTest -> testSum");
    }
    @Test
    public void testSum1 () {
        System.out.println("CalcTest1 -> testSum1");
    }
}
