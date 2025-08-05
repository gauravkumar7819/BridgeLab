import java.util.Scanner;

public class NestedTryCatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = {1, 2, 3, 4, 5};
        
        try {
            System.out.print("Enter array index: ");
            int index = scanner.nextInt();
            
            try {
                System.out.print("Enter divisor: ");
                int divisor = scanner.nextInt();
                
                int result = array[index] / divisor;
                System.out.println("Result: " + result);
                
            } catch (ArithmeticException e) {
                System.out.println("Error: Division by zero");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid array index");
        } finally {
            scanner.close();
        }
    }
}