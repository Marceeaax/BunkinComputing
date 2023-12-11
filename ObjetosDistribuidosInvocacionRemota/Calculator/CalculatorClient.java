import java.rmi.Naming;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            CalculatorService calculator = (CalculatorService) Naming.lookup("rmi://localhost/CalculatorService");

            double num1 = 10.0;
            double num2 = 5.0;

            double result = calculator.add(num1, num2);
            System.out.println("Addition result: " + result);

            result = calculator.sub(num1, num2);
            System.out.println("Subtraction result: " + result);

            result = calculator.mul(num1, num2);
            System.out.println("Multiplication result: " + result);

            result = calculator.div(num1, num2);
            System.out.println("Division result: " + result);
        } catch (Exception e) {
            System.err.println("Calculator client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
