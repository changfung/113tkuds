import java.util.*;

public class Q2_NextTHSRDeparture {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();            
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            String timeStr = sc.next();
            times[i] = toMinutes(timeStr);
        }

        String queryStr = sc.next();   
        int query = toMinutes(queryStr);

        int idx = Arrays.binarySearch(times, query + 1);
        if (idx < 0) {
            idx = -(idx + 1);            
        }

        if (idx == n) {
            System.out.println("No train");
        } else {
            System.out.println(toHHMM(times[idx]));
        }

        sc.close();
    }

    private static int toMinutes(String time) {
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        return hour * 60 + minute;
    }

    private static String toHHMM(int totalMinutes) {
        int hour = totalMinutes / 60;
        int minute = totalMinutes % 60;
        return String.format("%02d:%02d", hour, minute);
    }
}

/*
 * Time Complexity: O(log n)
 * 說明：
 * - Arrays.binarySearch 在已排序陣列上搜尋耗時 O(log n)
 * - 其他操作（讀取 n 筆資料、轉換時間）為 O(n)
 * - 因查詢是單次，所以總時間複雜度為 O(n + log n)
 */

