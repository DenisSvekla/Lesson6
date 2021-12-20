import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyTest {

    @Test (dependsOnMethods = "cbaTest")
    public void abcTest () {
        System.out.println("CalcTest1 -> abc");
        Assert.fail();
    }

    @Test
    public void cbaTest () {System.out.println("CalcTest1 -> cba"); }

    @Test (dependsOnMethods = "abcTest")
    public void bacTest () { System.out.println("CalcTest1 -> bac"); }
}
