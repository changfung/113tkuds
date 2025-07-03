import java.util.Scanner;

public class prnu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        for (int num = 2; num <= N; num++) {

            boolean isPrime = true;
            
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break; 
                }
            }
            
            if (isPrime) {
                System.out.print(num + " ");
            }
        }
        
        scanner.close();
    }
}

