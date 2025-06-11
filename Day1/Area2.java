class Area2 {

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        double radius = sc.nextDouble();
        double area = Math.PI * radius * radius;
        System.out.print(area);
        sc.close();
    }

}