import java.util.Scanner;

public class DivisionCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();
            
            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();
            
            double result = (double) num1 / num2;
            System.out.printf("Result: %.2f%n", result);
            
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed");
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Please enter valid numeric values");
        } finally {
            scanner.close();
        }
    }
}