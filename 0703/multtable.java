import java.util.Scanner;

public class multtable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
    
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println(); 
        }
        
        scanner.close();
    }
}
