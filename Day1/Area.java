import java.util.Scanner;

public class Area {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		double radius=sc.nextDouble();
		double area=Math.PI * radius * radius;
		System.out.print(area);
		
	}

}
