import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter first number:");
        double num1 = input.nextDouble();
        System.out.println("Enter second number:");
        double num2 = input.nextDouble();
        
        double addition = num1 + num2;
        double subtraction = num1 - num2;
        double multiplication = num1 * num2;
        double division = num1 / num2;
        
        System.out.printf("The addition, subtraction, multiplication and division value of 2 numbers %.2f and %.2f is %.2f, %.2f, %.2f, and %.2f", 
                         num1, num2, addition, subtraction, multiplication, division);
        input.close();
    }
}