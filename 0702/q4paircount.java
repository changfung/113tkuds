import java.util.Scanner;

public class q4paircount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int pairCount = n * (n - 1) / 2;

        System.out.println(pairCount);
    }
}