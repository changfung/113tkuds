import java.util.Scanner;

public class snake {
    public static void main(String[] args) {
     
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        
     
        if (N < 1 || N > 20) {

            return;
        }
        
        
        int[][] matrix = new int[N][N];
        
       
        int left = 0, right = N - 1, top = 0, bottom = N - 1;
        
        
        int num = 1;
        
        while (num <= N * N) {
           
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++;
            
       
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--; 
            
            
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = num++;
                }
                bottom--; 
            }
            
           
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = num++;
                }
                left++; 
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        scanner.close();
    }
}





