import java.util.Scanner;

public class forloopsum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int sum = 0;

        for (int i = 2; i <= N; i += 2) {
            sum += i;
        }

        System.out.println(sum);
        scanner.close();
    }
}
