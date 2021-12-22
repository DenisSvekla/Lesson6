import org.testng.ITestListener;

public class Listener implements ITestListener {
    void onTestFailurt (ITestListener result) {
        System.out.println("==============================");
        System.out.println("Screenshot has been captured.");
        System.out.println("==============================");
    }
}
