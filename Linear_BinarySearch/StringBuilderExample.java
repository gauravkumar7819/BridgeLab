import java.util.Scanner;

public class StringBuilderExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of words: ");
        int n = sc.nextInt();
        sc.nextLine();

        StringBuilder sb = new StringBuilder();

        System.out.println("Enter the words:");
        for (int i = 0; i < n; i++) {
            String word = sc.nextLine();
            sb.append(word);
            if (i != n - 1) {
                sb.append(" ");
            }
        }

        System.out.println("Combined String:");
        System.out.println(sb.toString());
    }
}

