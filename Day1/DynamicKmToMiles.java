import java.util.Scanner;

public class DynamicKmToMiles {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter distance in kilometers:");
        double km = input.nextDouble();
        double miles = km / 1.6;
        System.out.println("The total miles is " + miles + " mile for the given " + km + " km");
        input.close();
    }
}