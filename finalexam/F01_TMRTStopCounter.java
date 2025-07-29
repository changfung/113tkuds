import java.util.*;

public class F01_TMRTStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();              
        String[] stops = new String[n];    
        for (int i = 0; i < n; i++) {
            stops[i] = sc.next();          
        }

        String start = sc.next();          
        String end = sc.next();           

        int startIdx = -1;
        int endIdx = -1;

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
            System.out.println(Math.abs(startIdx - endIdx) + 1);
        }
    }
}

/*
 * Time Complexity: O(n)
 * 說明：需要線性掃描整個停靠站陣列一次，以尋找起點與終點站的索引位置。
 * 最壞情況下需比對 n 次（最多 131 次），屬於線性時間。
 *
 * Space Complexity: O(n)
 * 說明：使用一個長度為 n 的陣列來儲存所有站碼，其它變數為常數空間。
 */

