import java.util.Scanner;

public class colsum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] array = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        for (int j = 0; j < M; j++) {
            int columnSum = 0;
            for (int i = 0; i < N; i++) {
                columnSum += array[i][j];
            }
            System.out.print(columnSum + " ");
        }
        
        scanner.close();
    }
}

