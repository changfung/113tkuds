import java.util.*;

public class F02_YouBikeNextFull {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); 

        int[] times = new int[n];  
        for (int i = 0; i < n; i++) {
            String[] hm = sc.nextLine().split(":");
            int hour = Integer.parseInt(hm[0]);
            int min = Integer.parseInt(hm[1]);
            times[i] = hour * 60 + min;
        }

        String[] queryTime = sc.nextLine().split(":");
        int query = Integer.parseInt(queryTime[0]) * 60 + Integer.parseInt(queryTime[1]);

        int left = 0, right = n - 1;
        int ansIdx = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (times[mid] > query) {
                ansIdx = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (ansIdx == -1) {
            System.out.println("No bike");
        } else {
            int t = times[ansIdx];
            System.out.printf("%02d:%02d\n", t / 60, t % 60);
        }
    }
}

/*
 * Time Complexity: O(log n)
 * 說明：使用二分搜尋在排序後的時間陣列中尋找第一個大於查詢時間的元素，因此時間複雜度為對數時間。
 *
 * Space Complexity: O(n)
 * 說明：使用一個長度為 n 的整數陣列來儲存時間（分鐘），其餘變數為常數空間。
 */

