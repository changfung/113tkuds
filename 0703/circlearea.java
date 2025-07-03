import java.util.Scanner;

public class circlearea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double radius = scanner.nextDouble();
        double area = 3.14 * radius * radius;
        
        System.out.printf("%.2f\n", area);
        scanner.close();
    }
}

