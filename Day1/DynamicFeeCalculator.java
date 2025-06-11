import java.util.Scanner;

public class DynamicFeeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter fee amount:");
        double studentFee = input.nextDouble();
        System.out.println("Enter discount percentage:");
        double studentDiscount = input.nextDouble();
        double discountAmount = (studentFee * studentDiscount) / 100;
        double finalAmount = studentFee - discountAmount;
        System.out.println("The discount amount is INR " + discountAmount + 
                         " and final discounted fee is INR " + finalAmount);
        input.close();
    }
}