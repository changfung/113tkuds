import java.util.*;

public class F03_ConvenienceHotItems {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  
        sc.nextLine();         

        String[] names = new String[n];
        int[] qtys = new int[n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            names[i] = parts[0];
            qtys[i] = Integer.parseInt(parts[1]);
        }

        for (int i = 1; i < n; i++) {
            int keyQty = qtys[i];
            String keyName = names[i];
            int j = i - 1;

            while (j >= 0 && qtys[j] < keyQty) {
                qtys[j + 1] = qtys[j];
                names[j + 1] = names[j];
                j--;
            }
            qtys[j + 1] = keyQty;
            names[j + 1] = keyName;
        }

        int limit = Math.min(n, 10);
        for (int i = 0; i < limit; i++) {
            System.out.println(names[i] + " " + qtys[i]);
        }
    }
}

/*
 * Time Complexity: O(n^2)
 * 說明：插入排序在最壞情況（例如原始資料為遞增）下，每次插入都需要移動前面所有元素，總共最多執行約 n*(n-1)/2 次比較與移動，屬於二次時間。
 *
 * Space Complexity: O(n)
 * 說明：使用兩個長度為 n 的陣列分別儲存商品名稱與數量，其他為常數空間。
 */

