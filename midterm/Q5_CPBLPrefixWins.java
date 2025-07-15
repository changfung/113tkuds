import java.util.*;

public class Q5_CPBLPrefixWins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();             
        int[] results = new int[n];
        for (int i = 0; i < n; i++) {
            results[i] = sc.nextInt();     
        }

        int k = sc.nextInt();              

        int[] prefixSum = new int[n];
        prefixSum[0] = results[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + results[i];
        }

        System.out.print("PrefixSum:");
        for (int i = 0; i < k; i++) {
            System.out.print(" " + prefixSum[i]);
        }
        System.out.println();

        sc.close();
    }
}

/*
 * Time Complexity: O(n)
 * 說明：
 * - 建立 prefixSum 陣列需 O(n)
 * - 查詢前 k 項僅走訪 O(k)，但 k <= n
 * - 總時間複雜度為 O(n)
 */

