import java.util.*;

public class Q4_TieredElectricBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();             
        int total = 0;                  

        for (int i = 0; i < n; i++) {
            int kWh = sc.nextInt();      
            int amount = calc(kWh);     
            total += amount;
            System.out.println("Bill: $" + amount);
        }

        int average = Math.round((float) total / n);
        System.out.println("Total: $" + total);
        System.out.println("Average: $" + average);

        sc.close();
    }

    private static int calc(int kWh) {
        int[] limits = {120, 330, 500, 700, 1000};
        double[] rates = {1.68, 2.45, 3.70, 5.04, 6.24, 8.46};
        double cost = 0.0;
        int prev = 0;

        for (int i = 0; i < limits.length; i++) {
            int tierUsage = Math.min(kWh, limits[i]) - prev;
            if (tierUsage > 0) {
                cost += tierUsage * rates[i];
                prev = limits[i];
            }
            if (kWh <= limits[i]) break;
        }

        if (kWh > 1000) {
            cost += (kWh - 1000) * rates[5];
        }

        return (int) Math.round(cost); 
    }
}

/* 
 * Time Complexity: O(n)
 * 說明：
 * - 主程式走訪 n 戶，每戶計算帳單 O(1)（最多 6 段相減）
 * - 總時間複雜度為 O(n)
 */

