import java.util.Scanner;

public class ArrayOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] array = {1, 2, 3, 4, 5};
        
        try {
            System.out.print("Enter array index to access: ");
            int index = scanner.nextInt();
            
            System.out.println("Value at index " + index + ": " + array[index]);
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Error: Array is not initialized!");
        } finally {
            scanner.close();
        }
    }
}