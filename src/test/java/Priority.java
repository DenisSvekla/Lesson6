import org.testng.annotations.Test;

public class Priority {

    @Test (priority =2)
    public void abcTest () {
        System.out.println("CalcTest1 -> abc");
    }

    @Test (priority = 1)
    public void cbaTest () {System.out.println("CalcTest1 -> cba"); }

    @Test (priority = 2)
    public void bacTest () { System.out.println("CalcTest1 -> bac"); }
}
