import java.util.Scanner;

public class grade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int S = scanner.nextInt();
        
        if (S >= 90 && S <= 100) {
            System.out.println("A");
        } else if (S >= 80 && S < 90) {
            System.out.println("B");
        } else if (S >= 70 && S < 80) {
            System.out.println("C");
        } else if (S >= 60 && S < 70) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }

        scanner.close();
    }
}

