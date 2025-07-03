import java.util.Scanner;

public class q2seqsearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int key = scanner.nextInt();

        boolean found = false;
        int position = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == key) {
                found = true;
                position = i;
                break;
            }
        }

        if (found) {
            System.out.println("Yes");
            System.out.println(position);
        } else {
            System.out.println("No");
        }
    }
}