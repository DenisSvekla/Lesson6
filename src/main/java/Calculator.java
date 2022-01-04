public class Calculator {

    private String title;

    public Calculator(String title) {
        this.title = title;
    }

    public int sum(int a, int b) {
        return a + b;
    }
    public int substraction (int a, int b) {
        return a - b;
    }
    public double multiplication (double a, double b) {
        return  a * b;
    }
    public double division (double a, double b) {
        return a / b;
    }


    public String getTitle() {
        return title;
    }
}

