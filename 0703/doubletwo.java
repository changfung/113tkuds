import java.util.Scanner;

public class doubletwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double number = sc.nextDouble();

        System.out.printf("%.2f\n", number);

        sc.close();
    }
}
