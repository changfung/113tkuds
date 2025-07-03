public class matrix_multiplication_trace {
    public static void main(String[] args) {
        int[][] a = {
            {1, 2},
            {3, 4}
        };

        int[][] b = {
            {5, 6},
            {7, 8}
        };

        int[][] c = new int[2][2];

        System.out.println("計算過程：");

        for (int i = 0; i < 2; i++) { 
            for (int j = 0; j < 2; j++) { 
                StringBuilder formula = new StringBuilder("計算位置 c[" + i + "][" + j + "]：");
                StringBuilder products = new StringBuilder();
                int sum = 0;

                for (int k = 0; k < 2; k++) {
                    int product = a[i][k] * b[k][j];
                    sum += product;
                    formula.append(a[i][k] + "*" + b[k][j]);
                    products.append(product);
                    if (k < 1) {
                        formula.append(" + ");
                        products.append(" + ");
                    }
                }

                formula.append(" = ").append(products).append(" = ").append(sum);
                System.out.println(formula);
                c[i][j] = sum;
            }
        }

        System.out.println("\n結果矩陣：");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(c[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
//時間複雜度說明：
//這段程式使用了三層迴圈（i, j, k），所以時間複雜度為 O(n³)，其中 n 為矩陣的一邊長度：
//外層 i 迴圈跑 n 次（列）
//中層 j 迴圈跑 n 次（欄）
//內層 k 迴圈跑 n 次（相乘累加）
//總運算次數約為 n × n × n = O(n³)。