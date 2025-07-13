import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SearchComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter dataset size: ");
        int n = sc.nextInt();

        int[] data = new int[n];
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            data[i] = rand.nextInt(n * 10);
        }

        System.out.print("Enter target value to search: ");
        int target = sc.nextInt();

        long startLinear = System.nanoTime();
        boolean foundLinear = linearSearch(data, target);
        long endLinear = System.nanoTime();

        Arrays.sort(data);

        long startBinary = System.nanoTime();
        boolean foundBinary = binarySearch(data, target);
        long endBinary = System.nanoTime();

        System.out.println("Linear Search - Found: " + foundLinear + ", Time: " + (endLinear - startLinear) / 1_000_000.0 + " ms");
        System.out.println("Binary Search - Found: " + foundBinary + ", Time: " + (endBinary - startBinary) / 1_000_000.0 + " ms");
    }

    public static boolean linearSearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) return true;
        }
        return false;
    }

    public static boolean binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return true;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}
