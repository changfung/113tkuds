import java.util.Scanner;

public class whileloop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        long result = 1;
        for (int i = 1; i <= N; i++) {
            result *= i;
        } 

        System.out.println(result);
        scanner.close();
    }
}