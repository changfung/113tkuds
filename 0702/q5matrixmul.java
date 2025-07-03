import java.util.Scanner;

public class q5matrixmul {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] A = new int[n][n];
        int[][] B = new int[n][n];
        int[][] C = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                B[i][j] = scanner.nextInt();
            }
        }

        int mulCount = 0;
        int addCount = 0;

        for (int i = 0; i < n; i++) {         
            for (int j = 0; j < n; j++) {      
                C[i][j] = 0;
                for (int k = 0; k < n; k++) {  
                    C[i][j] += A[i][k] * B[k][j];
                    mulCount++;
                    if (k > 0) addCount++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(C[i][j]);
                if (j < n - 1) System.out.print(" ");
            }
            System.out.println();
        }

        System.out.println(mulCount + addCount);
    }
}