import java.util.*;

public class Q1_THSRStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();              
        String[] stops = new String[n];    
        for (int i = 0; i < n; i++) {
            stops[i] = sc.next();         
        }

        String start = sc.next();         
        String end = sc.next();            

        int startIdx = -1, endIdx = -1;

        for (int i = 0; i < n; i++) {
            if (stops[i].equals(start)) {
                startIdx = i;
            }
            if (stops[i].equals(end)) {
                endIdx = i;
            }
        }

        if (startIdx == -1 || endIdx == -1) {
            System.out.println("Invalid"); 
        } else {
            int count = Math.abs(startIdx - endIdx) + 1;
            System.out.println(count);    
        }

        sc.close();
    }
}

/*
 * Time Complexity: O(n)
 * 說明：
 * - 走訪陣列 stops 一次找 startIdx 和 endIdx，耗時 O(n)
 * - 其他操作（輸入、比較、abs）皆為 O(1)
 * - 總時間複雜度為 O(n)
 */


