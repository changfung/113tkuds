import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        int[][] transpose = new int[M][N];
        

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(transpose[i][j] + " ");
            }
            System.out.println();
        }
        
        scanner.close();
    }
}



